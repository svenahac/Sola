import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vpiši x: ");
        float x = sc.nextFloat();
        System.out.println("Vpiši y: ");
        float y = sc.nextFloat();
        System.out.println("Izberi operacijo - (+,-,*,/): ");
        String operacija = sc.next();

        switch (operacija) {
            case "+":
                System.out.println(x + y);
                break;
            case "-":
                System.out.println(x - y);
                break;
            case "*":
                System.out.println(x * y);
                break;
            case "/":
                System.out.println(x / y);
                break;
            default:
                System.out.println("Napaka");
        }

        sc.close();
    }
}