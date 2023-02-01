package devices;
import interfaces.Saleable;
import creatures.Human;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Car extends Devices implements Saleable {

    public Double millage;
    public Double value;
    public static Double FUEL_LEVEL = 25.0;
    public static Double DEFAULT_VALUE = 0.0;
    private List<Transaction> transactions;
    private Human currentOwner;


    public Car(String producer)
    {
        this.producer = producer;
        this.transactions = new ArrayList<>();
        this.currentOwner = null;

    }
    public Car(String producer, String model, Integer yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.value = DEFAULT_VALUE;
        this.millage = 0.0;
        this.transactions = new ArrayList<>();
        this.currentOwner = null;

    }
    public Car(String producer, String model, Integer yearOfProduction, Double value, Human currentOwner) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.value = value;
        this.millage = 0.0;
        this.transactions = new ArrayList<>();
        this.currentOwner = currentOwner;
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
        int sellerGarageIndex = -1;
        int buyerGarageIndex = -1;
        for (int i = 0; i < seller.garage.length; i++) {
            if (seller.garage[i] == this) {
                sellerGarageIndex = i;
                break;
            }
        }
        if (sellerGarageIndex == -1) {
            throw new IllegalStateException("Sprzedawca nie ma tego samochodu w garażu.");
        }
        for (int i = 0; i < buyer.garage.length; i++) {
            if (buyer.garage[i] == null) {
                buyerGarageIndex = i;
                break;
            }
        }
        if (buyerGarageIndex == -1) {
            throw new IllegalStateException("Kupujący nie ma miejsca w garażu na nowe samochody.");
        }
        if (buyer.getCash() < price) {
            throw new IllegalStateException("Kupujący nie ma tyle gotówki.");
        }
        seller.garage[sellerGarageIndex] = null;
        buyer.garage[buyerGarageIndex] = this;
        this.currentOwner = buyer;
        Transaction transaction = new Transaction(seller, buyer, price, new Date());
        this.transactions.add(transaction);

        System.out.println("Samochód " + this + " został sprzedany przez " + seller.getName() + " do " + buyer.getName() + " za " + price + " zł.");
        }
    abstract void refuel();
    public boolean wasOwner(Human human) {
        for (Transaction transaction : transactions) {
            if (transaction.getSeller() == human || transaction.getBuyer() == human) {
                return true;
            }
        }
        return false;
    }
    public boolean wasSoldTo(Human seller, Human buyer) {
        for (Transaction transaction : transactions) {
            if (transaction.getSeller() == seller && transaction.getBuyer() == buyer) {
                return true;
            }
        }
        return false;
    }
    public int transactionCount() {
        return this.transactions.size();
    }
    public List<Transaction> getTransactions() {
        return this.transactions;
    }
    public Human getCurrentOwner() {
        return this.currentOwner;
    }
    public void addOwner(Human owner) {
        this.currentOwner = owner;
        transactions.add(new Transaction(null, owner, 0.0, new Date()));
    }
    public int getTransactionCount() {
        return this.transactions.size();
    }
}

