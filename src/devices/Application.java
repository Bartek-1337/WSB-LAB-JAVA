package devices;

public class Application {
    private String name;
    private Double price;
    private String version;
    private static final Double DEFAULT_APP_PRICE = 0.0;

    public Application(String name, String version) {
        this.name = name;
        this.price = DEFAULT_APP_PRICE;
        this.version = version;
    }
    public Application(String name, Double price, String version) {
        this.name = name;
        this.price = price;
        this.version = version;
    }
    public String toString(){
        return "Nazwa aplikacji: " + name+", wersja: "+version+", cena: "+price;
    }
    public String getAppName() {
        return this.name;
    }

    public double getAppPrice() {
        return this.price;
    }

    public String getAppVersion() {
        return this.version;
    }

    public Double getPrice() {
        return this.price;
    }
}
