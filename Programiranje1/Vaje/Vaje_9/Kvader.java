public class Kvader extends Pravokotnik{
    
    int c;

    public Kvader(int a, int b, int c){
        super(a, b);
        this.c = c;
    }

    public int volumen(){
        return super.ploscina()*c;
    }
    
    public int povrsina(){
        return 2*(super.ploscina() + b*c + a*c);
    }
    
    // Polimorfizem -- Overriding
    public int ploscina(){
        return -1;
    }

    public int obseg(){
        return -1;
    }

    // Polimorfizem -- Overloading
    public int volumen(int a, int b, int c){
        return a * b * c;
    }

    public int volumen(double a, double b, double c){
        return (int)(a * b * c);
    }
}
