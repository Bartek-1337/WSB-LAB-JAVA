package devices;
import interfaces.Saleable;
import creatures.Human;
import java.util.List;
import java.net.URL;

public class Phone extends Devices  implements Saleable {
    public static final String DEFAULT_SERVER_ADDRESS = "https://appstore.com";
    public static final String DEFAULT_VERSION = "3.0";
    public Phone(String producer, String model, Integer yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }
    public String toString(){
        return "Producent: " + producer+", model: "+model+", rok produkcji: "+yearOfProduction;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Klik");
        System.out.println("Czekam");
        System.out.println("Logo");
        System.out.println("Czekam");
        System.out.println("Włączony");
    }
    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getPhone() != this) {
            System.out.println("Nie masz telefonu na sprzedaż.");
            return;
        }
        if (buyer.getCash() < price) {
            System.out.println("Kupujący nie ma wystarczająco gotówki. Weź pożyczkę.");
            return;
        }
        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);
        buyer.setPhone(seller.getPhone());
        seller.setPhone(null);
        System.out.println("Telefon " + this + " został sprzedany przez " + seller.getName() + " do " + buyer.getName() + " za " + price + " zł.");
    }
    public void installAnApp(String appName) {
        this.installAnApp(appName, DEFAULT_VERSION);;
    }
    public void installAnApp(String appName, String appVersion) {
        this.installAnApp(appName, appVersion, DEFAULT_SERVER_ADDRESS);
    }
    public void installAnApp(String appName, String appVersion, String serverAddress) {
        System.out.println("Instalacja aplikacji: " + appName + ", wersja: " + appVersion + ", z adresu serwera: " + serverAddress);
    }
    public void installAnApp(List<String> appNames) {
        for (String appName : appNames) {
            System.out.println("Instalacja aplikacji: " + appName);
        }
    }
    public void installAnApp(URL appURL) {
        System.out.println("Instalacja aplikacji z adresu serwera: " + appURL.toString());
    }
}