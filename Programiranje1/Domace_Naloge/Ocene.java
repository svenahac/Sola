import java.util.Scanner;

public class Ocene {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Vnesite oceno: ");
        int ocena = sc.nextInt();

        switch (ocena) {
            case 1: 
                System.out.println("Nezadostno");
                break;
            case 2:
                System.out.println("Zadostno");
                break;
            case 3:
                System.out.println("Dobro");
                break;
            case 4:
                System.out.println("Pravdobro");
                break;
            case 5:
                System.out.println("Odlično");
                break;
            default:
                System.out.println("Nepravilna ocena");
        }
        sc.close();
        
    }
}