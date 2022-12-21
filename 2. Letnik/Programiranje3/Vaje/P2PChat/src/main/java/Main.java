import com.google.gson.Gson;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final boolean trusted = true;
    public static void main(String[] args) {
        Crypto.generateKeyPair();
        DataManager dataManager = new DataManager();
        Message message = new Message(Protocol.CHAT_MESSAGE, "Hello this is first message");
        Crypto.sign(message).print();
        ExecutorService executorService = Executors.newCachedThreadPool();

        if (!trusted){
            try {
                Client trustedClient = new Client(new Socket("172.16.151.225", 1337), dataManager);
                trustedClient.sendMessage(new Message(Protocol.PEER_DISCOVERY, ""));
            } catch (IOException e){
               e.printStackTrace();
            }
        }

        try {
            ServerSocket serverSocket = new ServerSocket(1337);
            while (true) {
                Client c = new Client(serverSocket.accept(), dataManager);
                executorService.submit(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
