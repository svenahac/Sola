import java.util.Scanner;

public class Vaja4 {
    public static void main(String[] args) {
        Scanner vhod = new Scanner(System.in);
        System.out.print("Vnesi prvo stevilo: ");
        int prvo = vhod.nextInt();
        System.out.print("Vnesi drugo stevilo: ");
        int drugo = vhod.nextInt();

        String a = Integer.toString(prvo);
        String b = Integer.toString(drugo);

        if (a.length() == b.length()) {
            System.out.println(prvo);
        } else if (b.length() > a.length()) {
            System.out.println(drugo);
        }
    }
}
