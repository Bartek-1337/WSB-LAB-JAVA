import devices.Car;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Human {
    String name;
    private Car car;


    private Double salary;
    private Double lastSalaryCheckValue;
    private Date lastSalaryCheckDate;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public String toString(){
        return "Imię: " + name+", Wynagrodzenie: "+salary+", Samochód: "+car;
    }
    public Human(String name) {
        this.name = name;
    }
    public Double getSalary() {
        if (lastSalaryCheckDate!=null) {
            System.out.println("Ostatnie pobranie danych o wypłacie: " + formatter.format(lastSalaryCheckDate));
            System.out.println("Poprzedni stan wynagrodzenia: " + lastSalaryCheckValue);
            lastSalaryCheckDate = new Date();
            lastSalaryCheckValue = this.salary;
            return this.salary;
        }else
        {
            System.out.println("Ostatnie pobranie danych o wypłacie: Nie wystąpiło");
            System.out.println("Poprzedni stan wynagrodzenia: Nieznane");
            lastSalaryCheckDate = new Date();
            lastSalaryCheckValue = this.salary;
            return this.salary;
        }
    }

    public void setSalary(Double cash) {
        if (cash<0) {
            System.out.println("Wynagrodzenie nie może być ujemne :) Podaj prawidłową kwotę.");
        }
        else
        {
            System.out.println("Nowe dane zostały wysłane do systemu księgowego.");
            System.out.println("Pamiętaj o odebraniu aneksu do umowy od pani Hani z kadr i płac.");
            System.out.println("W ZUS i US już wiedzą o zmianie wynagrodzenia - nie ma sensu ukrywać dochodu :)");
            this.salary = cash;
        }

    }
    public void setCar(Car car) {
        if (salary>car.value)
        {
            System.out.println("Gratulacje! Kupiłeś samochód za gotówkę.");
            this.car = car;
        } else if (salary>(car.value/12)) {
            System.out.println("Gratulacje! Kupiłeś samochód w kredo.");
            this.car = car;
        } else
        {
            System.out.println("Nie stać Cię na auto. Pozostaje Ci je ukraść.");
        }

    }
    public Car getCar() {
        return this.car;
    }
}
