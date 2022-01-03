public class Lamborghini extends Car {

    public Lamborghini(String model, String color, int maxSpeed) {
        super(model, color, maxSpeed);
    }

    @Override
    public void bremzaj() {
        System.out.println("Bremzaj");
    }

    @Override
    public void pospesi() {
        System.out.println("Pospesi");
    }
    
}
