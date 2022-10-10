import java.util.*;

public class Vaja2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Vnesi velikost polja: ");
        int size = sc.nextInt();
        int[] polje = new int[size];
        for (int i = 0; i < size; i++) {
            polje[i] = sc.nextInt();
        }
        int max = polje[0];
        for (int i = 0; i < polje.length; i++) {
            if (polje[i] > max) {
                max = polje[i];
            }
        }
        int zmnozek = 1;
        System.out.println("Največje število je " + max);
        for (int i = 0; i < polje.length; i++) {
            if (polje[i] % 5 != 0) {
                zmnozek *= polje[i];
            }
        }
        System.out.println("Zmnožek števil, ki niso deljiva s 5 je: " + zmnozek);
        int n = polje.length/2;
        int vsota = 0;
        for (int i = n; i < polje.length; i++) {
            vsota += polje[i];
        }
        System.out.println("Vsota druge polovice števil je: " + vsota);
    }
}
