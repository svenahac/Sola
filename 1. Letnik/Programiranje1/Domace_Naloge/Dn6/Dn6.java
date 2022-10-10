import java.util.*;
public class Dn6 {
    public static long faktorsko(int i) {
      if(i <= 1) {
         return 1;
      }
      return i * faktorsko(i - 1);
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vpiši n: ");
        int n = sc.nextInt();
        System.out.println("Vpiši k: ");
        int k = sc.nextInt();
        

        long binom = faktorsko(n)/(faktorsko(k)*faktorsko(n-k));
        System.out.println("Binomski koeficient je: " + binom);
    }
}
