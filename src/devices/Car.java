package devices;

public class Car extends Devices {

    public Double millage;
    public Double value;
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
}

