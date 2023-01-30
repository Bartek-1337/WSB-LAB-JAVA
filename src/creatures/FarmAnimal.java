package creatures;

public class FarmAnimal extends Animal implements Edible {
    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        if (this.alive == true && this.weight > 0.0 && this.weight !=0.0) {
            this.alive = false;
            this.weight = 0.0;
            System.out.println("Zjadłeś zwierzę.");
        }else{
            System.out.println("Nie ma czego jeść.");
        }

    }
}
