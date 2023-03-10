package devices;

import creatures.Human;
import java.util.Date;
public class Transaction {
    private Human seller;
    private Human buyer;
    private double price;
    private Date date;

    public Transaction(Human seller, Human buyer, Double price, Date date) {
        this.seller = seller;
        this.buyer = buyer;
        this.price = price;
        this.date = date;
    }

    public Human getSeller() {
        return this.seller;
    }

    public Human getBuyer() {
        return this.buyer;
    }

    public double getPrice() {
        return this.price;
    }

    public Date getDate() {
        return this.date;
    }
}