import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {

        //zadanie 1
        System.out.println("\n--WYNIK ZADANIA 1--\n");
        Animal antylopa = new Animal("wołowate");
        antylopa.name="Antylopa";
        antylopa.weight=0.5;
        antylopa.alive=true;
        System.out.println("Gatunek: " + antylopa.species);
        System.out.println("Waga: " + antylopa.weight);
        System.out.println("Żyje: " + antylopa.alive);
        antylopa.feed();
        antylopa.takeForAWalk();
        antylopa.feed();

        antylopa.takeForAWalk();
        antylopa.takeForAWalk();
        antylopa.feed();
        antylopa.takeForAWalk();

        //zadanie 2
        System.out.println("\n--WYNIK ZADANIA 2--\n");
        Car passat = new Car("vw", "passerati", 2001, 10000.0);
        passat.millage = 78000.0;
        System.out.println("Producent auta: " + passat.producer);
        System.out.println("Model: " + passat.model);
        System.out.println("Rok produkcji: " + passat.yearOfProduction);
        System.out.println("Przebieg: " + passat.millage);


        Car fiat = new Car("fiat","bravo", 2010, 15000.0);
        fiat.millage = 312321.5;
        System.out.println("Producent auta: " + fiat.producer);
        System.out.println("Model: " + fiat.model);
        System.out.println("Rok produkcji: " + fiat.yearOfProduction);
        System.out.println("Przebieg: " + fiat.millage);


        //zadanie 3 i 4
        System.out.println("\n--WYNIK ZADANIA 3 I 4--\n");
        Human bartek = new Human("Bartek");
        bartek.setSalary(-1.0);
        bartek.setSalary(15000.0);
        bartek.getSalary();
        bartek.getSalary();

        //zadanie 5
        System.out.println("\n--WYNIK ZADANIA 5--\n");
        bartek.setCar(fiat);

        //zadanie 6
        System.out.println("\n--WYNIK ZADANIA 6--\n");
        System.out.println(fiat); //tutaj bez metody toString() w klasie zwracana byla nazwa klasy + kod obiektu
        System.out.println(passat);
        System.out.println(bartek);
        System.out.println(antylopa);
        Car passat2 = new Car("vw", "passerati", 2001, 10000.0);
        passat.millage = 78000.0;
        System.out.println("Producent auta: " + passat.producer);
        System.out.println("Model: " + passat.model);
        System.out.println("Rok produkcji: " + passat.yearOfProduction);
        System.out.println("Przebieg: " + passat.millage);
        System.out.println(passat.equals(passat2));

        //zadanie 7
        System.out.println("\n--WYNIK ZADANIA 7--\n");
        Phone samsung = new Phone("Samsung", "M52", 2020);
        System.out.println(samsung);
        samsung.turnOn();
        System.out.println(fiat);
        fiat.turnOn();
    }
}
