public class Nit extends Thread {

    private int start;
    private int end;
    private int[] data;
    private long result;
    public Nit(int start, int end, int[] data, long result){
        this.start = start;
        this.end = end;
        this.data = data;
        this.result = result;
    }

    @Override
    public void run() {
        long partSum = 0;
        for (int i = start; i < end; i++) {
            partSum += data[i];
        }
        Main.result += partSum;

    }
}
