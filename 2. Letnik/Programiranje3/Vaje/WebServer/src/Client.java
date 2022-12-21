import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class Client extends Thread{
    private Socket connection;
    private BufferedReader in;
    private PrintWriter out;
    private BufferedOutputStream dataOut;

    public Client(Socket connection) {
        this.connection = connection;
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new PrintWriter(connection.getOutputStream());
            dataOut = new BufferedOutputStream(connection.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void run() {
        try {
            String input = in.readLine();
            StringTokenizer parse = new StringTokenizer(input);
            String method = parse.nextToken().toUpperCase(Locale.ROOT);
            String resource = parse.nextToken().toLowerCase(Locale.ROOT);

            if (method.equals("GET")) {
                File file = new File("src/index.html");
                int contentLength = (int) file.length();
                String contentType = "text/html";
                byte[] fileData = readFile(file);
                out.println("HTTP/1.1 200 OK");
                out.println("Server: Pink Server");
                out.println("Date + " + new Date());
                out.println("Content-Type: " + contentType);
                out.println("Content-Length: " + contentLength);
                out.flush();
                dataOut.write(fileData, 0, contentLength);
                dataOut.flush();


            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                in.close();
                out.close();
                dataOut.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public byte[] readFile(File file){
        FileInputStream fs = null;
        byte[] data = new byte[(int) file.length()];
        try {
            fs = new FileInputStream(file);
            fs.read(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
