import java.util.Scanner;

public class Dn4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Vpiši ime: ");
        String ime = sc.nextLine();
        System.out.print("Vpiši priimek: ");
        String priimek = sc.nextLine();
        System.out.println("Lepo pozdravljen " + ime + " " + priimek + ", kako si kaj?");
    }
    
}