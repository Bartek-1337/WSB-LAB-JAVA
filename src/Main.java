import creatures.Animal;
import creatures.Human;
import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {

        //zadanie 8
        System.out.println("Inicjalizacja środowiska:");
        Car passat = new Car("vw", "passerati", 2001, 1000.0);
        Human bartek = new Human("Bartek");
        Human tomek = new Human("Tomek");
        bartek.setCash(10000.0);
        bartek.setSalary(10000.0);
        tomek.setCash(10000.0);
        tomek.setSalary(10000.0);
        tomek.setCar(passat, false);
        Animal pies = new Animal("Canis", "Burek", 5.0, true);
        tomek.setAnimal(pies);
        System.out.println("Transakcja:");
        passat.sell(tomek, bartek, 2000.0);
        Phone samsung = new Phone("Samsung", "M52", 2020);
        bartek.setPhone(samsung);
        samsung.sell(bartek, tomek, 500.0);
        pies.sell(tomek, bartek, 500.0);
        bartek.sell(tomek, bartek, 1000.0);
    }
}
