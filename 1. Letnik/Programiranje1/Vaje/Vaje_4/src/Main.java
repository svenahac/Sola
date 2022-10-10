import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vpiši velikost polja: ");
        int velikost = sc.nextInt();
        int polje[] = new int[velikost];
        for (int i = 0; i < velikost; i++) {
            polje[i] = sc.nextInt();
        }
        // vsota elementov
        int vsota = 0;
        for (int i = 0; i < polje.length; i++) {
            vsota = vsota + polje[i];
        }
        System.out.println("Vsota: " + vsota);
        
        // največji element
        int najvecji = polje[0];
        for (int i = 0; i < polje.length; i++) {
            if (polje[i] > najvecji) {
                najvecji = polje[i];
            }
        }
        System.out.println("Največji: " + najvecji);

        // stevilo sodih števil
        int counter = 0;
        for (int i = 0; i < polje.length; i++) {
            if (polje[i] % 2 == 0) {
                counter++;
            }
        }
        System.out.println("Št. sodih števil je: " + counter);

        //povprečje števil
        System.out.println("Povprečje je:" + (vsota/(polje.length*1.0)));

        // iskanje elementa
        int iskani = sc.nextInt();
        boolean haveFound = false;
        for (int i = 0; i < polje.length; i++) {
            if (iskani == polje[i] && haveFound == false){
                System.out.println("Yay");
                haveFound = true;
                break;
            }
        }
        if (haveFound == false){
            System.out.println("Nay");
        }

        // razlika sodih in lihih števil
        int soda = 0, liha = 0;
        for (int i = 0; i < polje.length; i++) {
            if (polje[i] % 2 == 0){
                soda += polje[i];
            } else {
                liha += polje[i];
            }
        }
        System.out.println("Razlika sodih in lihih je: " + (soda-liha));

        //obrni polje
        int obrnjeno[] = new int[velikost];
        for (int i = 0; i < polje.length; i++) {
            obrnjeno[polje.length-1 - i] = polje[i];
        }
        System.out.println("Obrnjeno: ");
        for (int i = 0; i < obrnjeno.length; i++) {
            System.out.print(obrnjeno[i] + ",");
        }
        sc.close();
    }
}
