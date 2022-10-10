import java.util.Scanner;

public class Vaja3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vnesi besedilo: ");
        String besedilo = sc.nextLine();
        String[] polje = besedilo.split("\\s+");
        for (int i = 0; i < polje.length; i++) {
            if(polje[i].charAt(0) == 'b'){
                System.out.println(polje[i]);
            }

        }
    }
}
