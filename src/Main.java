import creatures.Human;
import devices.Electric;
public class Main {
    public static void main(String[] args) {
        Human bartek = new Human("Bartek");
        System.out.println(bartek);
        Human tomek = new Human("Tomek", 200.0,4000.0,1);
        System.out.println(tomek);
        Electric tesla = new Electric("Tesla", "1", 2023, 1000.0, bartek);
        System.out.println(tesla);
        System.out.println("Wartość samochodów Bartka: "+ bartek.getValueOfAllCars());
        System.out.println("Wartość samochodów Tomka: "+ tomek.getValueOfAllCars());
        System.out.println("Kupuję samochód z salonu:");
        bartek.setCar(tesla, 1);
        System.out.println("Wartość samochodów Bartka: "+ bartek.getValueOfAllCars());
        System.out.println("Wartość samochodów Tomka: "+ tomek.getValueOfAllCars());
        System.out.println(tesla.getCurrentOwner());
        System.out.println("Czy bartek posiadał samochów: "+ tesla.wasOwner(bartek));
        System.out.println("Czy tomek posiadał samochów: "+ tesla.wasOwner(tomek));
        System.out.println("Sprzedaję auto:");
        tesla.sell(bartek,tomek,1000.0);
        System.out.println("Czy bartek sprzedał samochód tomkowi: "+ tesla.wasSoldTo(bartek, tomek));
        System.out.println("Czy tomek sprzedałsamochód bartkowi: "+ tesla.wasSoldTo(tomek, bartek));
        System.out.println("Wartość samochodów Bartka: "+ bartek.getValueOfAllCars());
        System.out.println("Wartość samochodów Tomka: "+ tomek.getValueOfAllCars());
        System.out.println("Ostatni właściciel samochodu: "+ tesla.getCurrentOwner());
        tesla.sell(tomek,bartek,1000.0);
        System.out.println("Wartość samochodów Bartka: "+ bartek.getValueOfAllCars());
        System.out.println("Wartość samochodów Tomka: "+ tomek.getValueOfAllCars());
        System.out.println("Ostatni właściciel samochodu: "+ tesla.getCurrentOwner());
        System.out.println("Liczba transakcji samochodu: "+ tesla.transactionCount());
        System.out.println("Czy bartek posiadał samochów: "+ tesla.wasOwner(bartek));
        System.out.println("Czy tomek posiadał samochów: "+ tesla.wasOwner(tomek));
        System.out.println("Czy bartek sprzedał samochód tomkowi: "+ tesla.wasSoldTo(bartek, tomek));
        System.out.println("Czy tomek sprzedałsamochód bartkowi: "+ tesla.wasSoldTo(tomek, bartek));
        System.out.println("Transakcje, w których samochód brał udział: "+ tesla.getTransactionCount());
    }
}
