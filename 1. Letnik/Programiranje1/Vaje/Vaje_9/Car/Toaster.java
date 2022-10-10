public class Toaster implements Device {

    public String model;
    public int maxPower;
    
    public Toaster(String model, int maxPower) {
        this.model = model;
        this.maxPower = maxPower;
    }

    @Override
    public void turnOn() {
        System.out.println("Toaster je prižgan");
    }

    @Override
    public void turnOff() {
        System.out.println("Toaster je ugasnjen");
    }
    
}
