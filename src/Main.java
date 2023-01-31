import creatures.FarmAnimal;
import creatures.Pet;
import creatures.Animal;
import creatures.Human;
import devices.Car;
import devices.Disel;
import devices.LPG;
import devices.Electric;
import devices.Phone;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Arrays;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        Phone samsung = new Phone("samsung", "m52", 2020);
        samsung.installAnApp("Aparat");
        List<String> appNames = Arrays.asList("Mozilla", "Chrome", "Edge");
        samsung.installAnApp(appNames);
        try {
            URL appURL = new URL("https://www.smiesznekotki.com/");
            samsung.installAnApp(appURL);
        } catch (MalformedURLException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
        Disel auto1 = new Disel("Zdunek", "Szybki", 2020, 1000.0);
        LPG auto2 = new LPG("Zdunek", "Wolny", 2022, 2000.0);
        Electric auto3 = new Electric("Zdunek", "Niebieski", 2021, 3000.0);
        auto1.refuel();
        auto2.refuel();
        auto3.refuel();
    }
}
