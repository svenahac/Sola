import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final boolean loadBalancer = false;
    public static final int port = 8080;
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                pool.submit(new Client(serverSocket.accept()));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}