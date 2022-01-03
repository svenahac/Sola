public class Daljica {
    Tocka A;
    Tocka B;

    public Daljica(Tocka A, Tocka B) {
        this.A = A;
        this.B = B;
    }
    public double length(){
        double prvi = Math.pow(A.getX() - B.getX(),2);
        double drugi = Math.pow(A.getY() - B.getY(),2);
        return Math.sqrt(prvi+drugi);
    }
}
