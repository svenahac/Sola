import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Vnesi x za tocko a: ");
        int ax = sc.nextInt();
        System.out.print("Vnesi y za tocko a: ");
        int ay = sc.nextInt();
        System.out.println("----------------------");
        System.out.print("Vnesi x za tocko b: ");
        int bx = sc.nextInt();
        System.out.print("Vnesi y za tocko b: ");
        int by = sc.nextInt();

        Tocka a = new Tocka(ax, ay);
        Tocka b = new Tocka(bx, by);

        Krog krog = new Krog(a, b);

        System.out.println(krog.obseg());
        System.out.println(krog.ploscina());

    }
}
