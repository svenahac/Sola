public class Trikotnik {
    Daljica hipotenuza;
    Tocka B;
    Tocka A;
    Tocka C;

    public Trikotnik(Daljica hipotenuza, Tocka B) {
        this.hipotenuza = hipotenuza;
        this.A = hipotenuza.A;
        this.C = hipotenuza.B;
        this.B = B;
    }

    public double ploscina() {
        Daljica AB = new Daljica(A, B);
        Daljica BC = new Daljica(B, C);
        double s = (AB.length() + BC.length() + hipotenuza.length()) / 2;
        return Math.sqrt(s*(s - AB.length())*(s - BC.length()) * (s - hipotenuza.length()));
    }
}
