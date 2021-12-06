public class Main {
    public static void main(String[] args) {
        PovezanSeznam seznam = new PovezanSeznam();
        seznam.vstavi(10);
        seznam.vstavi(2);
        seznam.vstavi(20);
        
        System.out.println(seznam.najdi(2));
        System.out.println(seznam.najdi(100));

        System.out.println(seznam.brisi(2));

        System.out.println(seznam.najdi(2));

        seznam.izpisi();
    }
}
