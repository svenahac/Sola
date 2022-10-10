public class Start {
    public static void main(String[] args) {
        Lamborghini lambo = new Lamborghini("cizeta-moroder", "black", 325);
        lambo.pospesi();
        lambo.pospesi();
        lambo.bremzaj();
        
        Toaster toast = new Toaster("Mitsubishi", 200);
        toast.turnOn();
        toast.turnOff();
    }
}
