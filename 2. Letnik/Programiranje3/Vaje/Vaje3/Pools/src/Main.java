import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static int n = 1000;

    public static void main(String[] args) {
        /* newSingleThreadExecutor da bo samo en thread, za projekt*/
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int a[][] = generateMatrix(n);
        int b[][] = generateMatrix(n);
        int c[][] = new int[n][n];
        long start = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            R r = new R(i, a, b, c);
            executorService.submit(r);

        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("Done in " + (System.currentTimeMillis() - start) + " ms");


    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }
        return matrix;
    }

    
}