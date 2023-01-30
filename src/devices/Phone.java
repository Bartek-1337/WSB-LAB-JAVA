package devices;
import interfaces.Saleable;
import creatures.Human;

public class Phone extends Devices  implements Saleable {
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
}