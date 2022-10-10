import java.util.Scanner;

public class Vaja3 {
    public static void main(String[] args) {
        Scanner vhod = new Scanner(System.in);
        int a = vhod.nextInt();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == 0 || i == a-1 || i + j == a - 1 || j == i) { // (i >j) (i + j >= a - 1) (i == 0 || i == a-1 || j == 0 || j == a-1) (i == 0 || i == a-1 || i + j == a - 1 || j == i)
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        vhod.close();
    }
}