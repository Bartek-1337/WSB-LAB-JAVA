package devices;
import interfaces.Saleable;
import creatures.Human;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.net.URL;

public class Phone extends Devices  implements Saleable {
    private static final String DEFAULT_SERVER_ADDRESS = "https://appstore.com";
    private static final String DEFAULT_VERSION = "3.0";
    private ArrayList<Application> apps;
    public Phone(String producer, String model, Integer yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        apps = new ArrayList<Application>();
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
    public void installAnApp(Human installer, Application app) {
        if (installer.getCash() < app.getAppPrice()) {
            System.out.println("Nie masz wystarczająco środków, aby kupić aplikację "+app);
            return;
        }
        installer.setCash(installer.getCash() - app.getAppPrice());
        System.out.println("Kupiłeś aplikację. Instaluję... "+ app);
        apps.add(app);
    }
    public boolean isAppInstalled(String appName) {
        for (Application app : apps) {
            if (app.getAppName().equals(appName)) {
                return true;
            }
        }
        return false;
    }
    public Boolean isInstalled(Application app) {
        for (Application appList : apps) {
            if (app == appList) {
                return true;
                }
            }
        return false;
    }
    public Boolean isInstalled(String appName) {
    for (Application appList : apps) {
        if (appName == appList.getAppName()) {
            return true;
            }
        }
    return false;
    }
    public List<Application> showFreeApps() {
        List<Application> freeApps = new ArrayList<>();
        for (Application app : apps) {
            if (app.getAppPrice() == 0) {
                freeApps.add(app);
            }
        }
        return freeApps;
    }
    public List<Application> getInstalledApps() {
        return apps;
    }

    public List<Application> getInstalledAppsAlphabetically() {
        List<Application> sortedAppsByName = new ArrayList<>(apps);
        Collections.sort(sortedAppsByName, (app1, app2) -> app1.getAppName().compareTo(app2.getAppName()));
        return sortedAppsByName;
    }

    public List<Application> getInstalledAppsByPrice() {
        List<Application> sortedAppsByPrice = new ArrayList<>(apps);
        Collections.sort(sortedAppsByPrice, (app1, app2) -> Double.compare(app1.getAppPrice(), app2.getAppPrice()));
        return sortedAppsByPrice;
    }
    public Double getAllAppsValue() {
        Double appValue = 0.0;
        for (Application app : apps) {
            appValue += app.getPrice();
            }
        return appValue;
        }
}