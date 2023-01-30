import creatures.FarmAnimal;
import creatures.Pet;
import creatures.Animal;
import creatures.Human;
import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test Pet");
        Pet kot = new Pet ("Canis");
        kot.feed(5.0);
        kot.feed();
        kot.takeForAWalk(6.0);
        kot.takeForAWalk();
        kot.takeForAWalk();
        kot.takeForAWalk();
        kot.feed();
        kot.takeForAWalk();
        System.out.println("Test FarmAnimal");
        FarmAnimal kura = new FarmAnimal("Kur bankiwa");
        kura.takeForAWalk();
        kura.feed();
        kura.beEaten();
        kura.feed();
        kura.takeForAWalk();
        kura.beEaten();
    }
}
