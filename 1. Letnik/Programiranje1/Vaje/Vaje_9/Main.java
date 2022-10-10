public class Main {
    public static void main(String[] args) {
        Pravokotnik lik1 = new Pravokotnik(4, 5);
        System.out.println("Ploscina pravokotnika: " + lik1.ploscina());
        System.out.println("Obseg pravokotnika: " + lik1.obseg());

        Kvader lik2 = new Kvader(4, 5, 3);
        System.out.println("Volumen kvadra: " + lik2.volumen());
        System.out.println("Povrsina kvadra: " + lik2.povrsina());

        System.out.println("Ploscina kvadra: " + lik2.ploscina());

        System.out.println("Volumen poljubnega kvadra: " + lik2.volumen(1,1,1));

        Kocka lik3 = new Kocka(5);
        System.out.println("Volumen kvadra: " + lik3.volumen());
        System.out.println("Povrsina kvadra: " + lik3.povrsina());
    }
}
