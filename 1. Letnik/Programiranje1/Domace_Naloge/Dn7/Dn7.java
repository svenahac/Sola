import java.util.Scanner;

public class Dn7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Vnesi niz: ");
        String niz = sc.nextLine();
        for (int i = 0; i < niz.length(); i++) {
            if (i % 2 == 0) {
                System.out.print(niz.charAt(i));
            }
        }
    }
}