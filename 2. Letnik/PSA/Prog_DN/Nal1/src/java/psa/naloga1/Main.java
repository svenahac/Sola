package psa.naloga1;

public class Main {
    public static void main(String[] args) {
        Seznam seznam = new Seznam();
        Binarno binarno = new Binarno();

        System.out.println(binarno.insert(5));
        System.out.println(binarno.insert(54));
        System.out.println(binarno.insert(22));
        System.out.println(binarno.insert(5));
        System.out.println(binarno.insert(3));
        System.out.println("-------------------");
        System.out.println(binarno.search(5));
        System.out.println(binarno.search(532));
        System.out.println(binarno.search(1));
        System.out.println(binarno.search(3));
        System.out.println(binarno.search(56));
        System.out.println("-------------------");
        System.out.println(binarno.delete(3));
        System.out.println(binarno.search(3));
    }
}
