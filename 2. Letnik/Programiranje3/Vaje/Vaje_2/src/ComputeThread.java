public class ComputeThread extends Thread {
    private int i;

    public ComputeThread(int i) {
        this.i = i;
    }

    public void run(){
        for (int j = 0; j < Main.n; j++) {
            for (int k = 0; k < Main.n; k++) {
                Main.C[i][j] += Main.A[i][k] * Main.B[k][j];
            }
        }
    }
}
