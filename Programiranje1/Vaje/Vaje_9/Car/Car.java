public abstract class Car {
    
    public String model;
    private String color;
    private int maxSpeed;

    public abstract void pospesi();

    public abstract void bremzaj();

    public Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    
}
