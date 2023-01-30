package creatures;

import interfaces.Saleable;

public abstract class Animal implements Saleable, Feedable {
    public String species;
    public String name;
    public Double weight;
    public Boolean alive;
    private static Double DEFAULT_WEIGHT = 2.0;
    private static Double DEFAULT_FOOD_WEIGHT = 0.5;
    private static Double DEFAULT_WALK_LENGTH = 0.5;

    public Animal(String species){
        this.species = species;
        this.alive = true;
        this.weight = DEFAULT_WEIGHT;
    }
    public Animal(String species, String name, Double weight, Boolean alive) {
        this.species = species;
        this.name = name;
        this.weight = weight;
        this.alive = alive;
    }
    public String toString(){
        return "Gatunek: " + species+", Nazwa: "+name+", Waga: "+weight + ", Czy żywy?: " + (this.alive ? "tak" : "nie");
    }
    public void feed() {
        feed(DEFAULT_FOOD_WEIGHT);
    }
    public void feed(Double foodWeight) {
        if (this.weight != 0.0 && this.weight > 0.0 && this.alive == true) {
            this.weight += foodWeight;
            System.out.println("Karmisz zwierzę...");
            System.out.println("Masa zwierzęcia: " + this.weight);
        } else {
            System.out.println("Próbujesz nakarmić martwe zwierzę.");
        }
    }
    public void takeForAWalk(){
        takeForAWalk(DEFAULT_WALK_LENGTH);
    }
    public void takeForAWalk(Double walkLength){
        if(this.weight!=0.0 && this.weight>0.0 && this.alive==true)
        {
            this.weight-=walkLength;
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
            System.out.println("Nie masz zwierzaka na sprzedaż.");
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