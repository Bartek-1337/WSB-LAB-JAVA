package devices;

import creatures.Human;

public class LPG extends Car {
    public LPG(String producer, String model, Integer yearOfProduction, Double value, Human human) {
        super(producer, model, yearOfProduction, value, human);
    }
    @Override
    public void refuel()
    {
        System.out.println("Tankujesz LPG...");
        this.FUEL_LEVEL+=5.0;
        System.out.println("Poziom zbiornika to " + FUEL_LEVEL +"L.");
    }
}
