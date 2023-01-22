package devices;

public class Phone extends Devices {
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
}