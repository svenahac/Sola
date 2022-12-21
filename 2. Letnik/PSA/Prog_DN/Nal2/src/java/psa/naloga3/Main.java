package psa.naloga3;

public class Main {
    public static void main(String[] args) {

        SkipList sl = new SkipList(64);
        System.out.println(sl.insert(1));
        System.out.println(sl.insert(2));
        System.out.println(sl.insert(2));
        System.out.println(sl.insert(3));
        System.out.println(sl.insert(4));
        System.out.println(sl.insert(5));
        System.out.println("----------------");
        System.out.println(sl.search(1));
        System.out.println(sl.search(8));
        System.out.println(sl.search(3));
        System.out.println("----------------");
        System.out.println(sl.delete(1));
        System.out.println(sl.search(1));

    }
}
