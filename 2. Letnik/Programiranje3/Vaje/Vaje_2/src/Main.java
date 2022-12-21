import java.util.Random;

public class Main {

    static int A[][];
    static int B[][];
    static int C[][];
    static int n = 1000;

    public static void main(String[] args) {
        A = new int[n][n];
        B = new int[n][n];
        C = new int[n][n];
        generate();
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        System.out.println("Sequential: " + (System.currentTimeMillis()-start));
        start = System.currentTimeMillis();
        ComputeThread[] threads = new ComputeThread[n];

        for (int i = 0; i < n; i++) {
            threads[i] = new ComputeThread(i);
        }
        for (int i = 0; i < n; i++) {
            threads[i].start();
        }
        for (int i = 0; i < n; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Parralel: " + (System.currentTimeMillis()-start));
    }

    public static void generate() {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = random.nextInt(10);
                B[i][j] = random.nextInt(10);

            }
        }
    }

    public static void print(int [][] C){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}