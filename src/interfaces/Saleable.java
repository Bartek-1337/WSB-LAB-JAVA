package interfaces;
import creatures.Human;

public interface Saleable {
    void sell(Human seller, Human buyer, Double price);

}