package devices;
import interfaces.Saleable;
import creatures.Human;
public abstract class Car extends Devices implements Saleable {

    public Double millage;
    public Double value;
    public static Double FUEL_LEVEL = 25.0;

    public Car(String producer)
    {
        this.producer = producer;
    }
    public Car(String producer, String model, Integer yearOfProduction, Double value) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.value = value;
        this.millage = 0.0;
    }
    public String toString(){
        return "Producent: " + producer+", model: "+model+", rok produkcji: "+yearOfProduction + ", przebieg: " + millage + ", cena: " + value;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("Przekręcam kluczyk");
        System.out.println("WRRR");
        System.out.println("WRRRR");
        System.out.println("WRRR");
        System.out.println("Odpalony");
    }
    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getCar() != this) {
            System.out.println("Nie masz auta na sprzedaż.");
            return;
        }
        if (buyer.getCash() < price) {
            System.out.println("Kupujący nie ma wystarczająco gotówki. Weź pożyczkę.");
            return;
        }
        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);
        buyer.setCar(seller.getCar(), true);
        seller.setCar(null, true);
        System.out.println("Samochód " + this + " został sprzedany przez " + seller.getName() + " do " + buyer.getName() + " za " + price + " zł.");
    }
    abstract void refuel();
}

