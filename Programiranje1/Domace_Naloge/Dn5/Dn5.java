import java.util.Scanner;
public class Dn5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vpišite število n: ");
        int stevilo = sc.nextInt();
        int vsota = 0;
        for (int i = 0; i < stevilo; i++) {
            if (i % 2 == 0){
                vsota += i;
            }
        }
        System.out.println("Vsota sodih števil med 0 in " + stevilo + " je: " + vsota);    
        sc.close();
    }
}
