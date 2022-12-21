import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Client extends Thread {
    private Socket         connection;
    private BufferedReader in;
    private BufferedWriter out;
    private Gson           gson;
    private DataManager dataManager;
    private String publicKey;

    public Client(Socket connection, DataManager dataManager) {
        this.gson       = new Gson();
        this.connection = connection;
        this.dataManager = dataManager;
        try {
            in  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("Connection established with: " + connection.getInetAddress());
        String line;
        try {
            while ((line = in.readLine()) != null) {
                Message message = gson.fromJson(line, Message.class);
                if (Crypto.verify(message, message.signer)){
                    System.out.println(Constants.SUCCESS + "Signature verification success!");
                    if (!dataManager.clients.containsKey(message.signer)){
                        dataManager.clients.put(message.body, this);
                        this.publicKey = message.signer;
                        System.out.println(Constants.NETWORK + "New peer added!");
                    }
                    switch (message.protocol){
                        case CHAT_MESSAGE:
                            dataManager.clients.values().forEach(client ->
                                    client.sendMessage(message)
                            );
                            break;
                        case PEER_DISCOVERY:
                            if (message.body.isEmpty()){
                                List<ClientInfo> clientInfoList = new LinkedList<>();
                                dataManager.clients
                                    .values()
                                    .stream()
                                    .filter(client -> client.getIpAddress() != this.getIpAddress())
                                    .collect(Collectors.toList()).forEach(client -> clientInfoList.add(client.getInfo())
                                        );
                                System.out.println(Constants.NETWORK + "Sending " + clientInfoList.size() + " peers");
                                Message response = new Message(Protocol.PEER_DISCOVERY, gson.toJson(clientInfoList.toArray(), ClientInfo[].class));
                                sendMessage(response);
                            } else {
                                ClientInfo[] newClients = gson.fromJson(message.body, ClientInfo[].class);
                                System.out.println(Constants.NETWORK + "Received " + newClients.length + " new peers");
                                Arrays.stream(newClients).forEach(clientInfo ->
                                {
                                    try {
                                        new Client(new Socket(clientInfo.ip, clientInfo.port), dataManager);
                                    } catch (IOException e) {
                                        System.out.println(Constants.ERROR + " Connection to new client failed " + e.getMessage());
                                    }
                                }
                                        );
                            }
                            break;
                        default:
                            System.out.println(Constants.ERROR + "Unknown protocol: " + message.protocol);
                            break;
                    }
                } else {
                    System.out.println(Constants.ERROR + "Signature verification failed!");
                }

            }
        } catch (Exception e) {
            System.out.println("Protocol violation. Closing connection!");
            try {
                in.close();
                out.close();
                connection.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public String getIpAddress(){
        return connection.getInetAddress().toString();
    }

    public ClientInfo getInfo(){
        return new ClientInfo(getIpAddress(), 1337);
    }
    public void sendMessage(Message message){
        try {
            out.write(gson.toJson(Crypto.sign(message)));
            out.newLine();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
