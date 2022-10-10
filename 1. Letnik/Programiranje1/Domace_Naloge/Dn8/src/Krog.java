public class Krog {
    private Tocka sredisce;
    private Tocka kroznica;

    public Krog(Tocka a, Tocka b){
        this.sredisce = a;
        this.kroznica = b;
    }
    public double polmer(Tocka kroznica, Tocka sredisce){
        double prvi = Math.pow(kroznica.getX() - sredisce.getX(),2);
        double drugi = Math.pow(kroznica.getY() - sredisce.getY(),2);
        return Math.sqrt(prvi+drugi);
    }

    public double obseg(){
        return (2*(Math.PI)*polmer(kroznica, sredisce));
    }
    public double ploscina() {
        return (Math.PI*Math.pow(polmer(kroznica, sredisce),2));
    }
}
