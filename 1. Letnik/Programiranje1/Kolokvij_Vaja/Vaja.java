import java.util.*;

public class Vaja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Vnesi besedilo: ");
        String besedilo = sc.nextLine();
        besedilo = besedilo.replace(" ", "");
        System.out.println(besedilo);

    }
}
