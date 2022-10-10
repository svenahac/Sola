public class Pravokotnik {

    int a;
    int b;

    public Pravokotnik(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int ploscina(){
        return a*b;
    }

    public int obseg(){
        return 2*(a+b);
    }
}
