import java.util.Random;

public class Main {

    public static long result = 0;

    public static void main(String[] args) {
        int data[] = new int[199999999];
        int n = Runtime.getRuntime().availableProcessors();
        Random random = new Random();


        for (int i = 0; i < data.length ; i++) {
            data[i] = random.nextInt(123456);
        }

        int chunk = data.length / n ;
        long currentTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }

        System.out.println(sum);
        long afterTime = System.currentTimeMillis();
        System.out.println("Sequential time: " + (afterTime-currentTime));

        Nit niti[] = new Nit[n];
        currentTime = System.currentTimeMillis();
        for (int i = 0; i < niti.length-1; i++) {
            niti[i] = new Nit(i*chunk, i*chunk+chunk, data, result);
            niti[i].start();
        }

        niti[n-1] = new Nit((n-1)*chunk, data.length, data, result);
        niti[n-1].start();
        for (int i = 0; i < niti.length; i++) {
            try {
                niti[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Parallel: " + (System.currentTimeMillis() - currentTime));
        System.out.println(result);
    }
}