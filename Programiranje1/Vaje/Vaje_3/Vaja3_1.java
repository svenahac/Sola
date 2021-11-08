public class Vaja3_1 {
    public static void main(String[] args) {
        int a[][] = new int[5][5];
        a[3][3] = 10;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) { // a[0].length ali a[i].length če je matrika razlicne dolzine npr. [5][4]
                System.out.print(a[i][j] + ",");
            }
            System.out.println();
        }
        /*
        int a[] = new int[5];
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        */
        /*
        int a[] = {5, 3, 7, 23, 654, 22, 143};
        int najvecji = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > najvecji) {
                najvecji = a[i];
            }
        }
        System.out.println(najvecji);
        */
    }
}