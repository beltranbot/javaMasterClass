public class Car extends Vehicle {
    private int doors;
    private int engineCapability;

    public Car(String name, int doors, int engineCapability) {
        super(name);
        this.doors = doors;
        this.engineCapability = engineCapability;
    }
}
