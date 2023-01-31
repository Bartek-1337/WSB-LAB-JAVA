package devices;

import creatures.Human;

public class Electric extends Car {
    public Electric(String producer, String model, Integer yearOfProduction, Double value, Human human) {
        super(producer, model, yearOfProduction, value, human);
    }
    @Override
    public void refuel()
    {
        System.out.println("Tankujesz elektryka...");
        this.FUEL_LEVEL+=5.0;
        System.out.println("Poziom naładowania to " + FUEL_LEVEL +"%.");
    }
}
