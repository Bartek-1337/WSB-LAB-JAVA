package creatures;

import interfaces.Saleable;

public class Animal implements Saleable {
    public String species;
    public String name;
    public Double weight;
    public Boolean alive;

    public Animal(String species, String name, Double weight, Boolean alive) {
        this.name = name;
        this.species = species;
        this.weight = weight;
        this.alive = alive;
    }
    public String toString(){
        return "Gatunek: " + species+", Nazwa: "+name+", Waga: "+weight + ", Czy żywy?: " + alive;
    }
    public void feed(){
        if(this.weight!=0.0 || this.weight>0.0 || this.alive==false)
        {
            this.weight+=0.5;
            System.out.println("Karmisz zwierzę...");
            System.out.println("Masa zwierzęcia: " + this.weight);
        }
        else {
            System.out.println("Próbujesz nakarmić martwe zwierzę.");
        }
    }
    public void takeForAWalk(){
        if(this.weight!=0.0 || this.weight>0.0 || this.alive==false)
        {
            this.weight-=0.5;
            System.out.println("Wyprowadzasz zwierzę na spacer...");
            System.out.println("Masa zwierzęcia: " + this.weight);
            if (this.weight==0) System.out.println("Zabiłeś zwierzę.");
        }
        else
        {
            this.alive=false;
            System.out.println("Próbujesz wyprowadzić martwe zwierzę.");
        }
    }
    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getAnimal() != this) {
            System.out.println("Nie masz auta na sprzedaż.");
            return;
        }
        if (buyer.getCash() < price) {
            System.out.println("Kupujący nie ma wystarczająco gotówki. Weź pożyczkę.");
            return;
        }
        buyer.setCash(buyer.getCash() - price);
        seller.setCash(seller.getCash() + price);
        buyer.setAnimal(seller.getAnimal());
        seller.setAnimal(null);
        System.out.println("Zwierzę " + this + " został sprzedany przez " + seller.getName() + " do " + buyer.getName() + " za " + price + " zł.");
    }
}