public class Kocka {
    Kvadrat base;
    int v;
    public Kocka(Kvadrat base, int v) {
        this.base = base;
        this.v = v;
    }

    public double volume() {
        return base.ploscina() * v;
    }
}
