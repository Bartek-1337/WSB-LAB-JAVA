package creatures;

import devices.Phone;
import devices.Car;
import interfaces.Saleable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Human implements Saleable {
    String name;
    public Car[] garage;
    private Phone phone;
    private Animal animal;
    private Double cash;
    private static Double DEFAULT_CASH = 10000.0;
    private Double salary;
    private static Double DEFAULT_SALARY = 3500.0;
    private Double lastSalaryCheckValue;
    private Date lastSalaryCheckDate;
    private static Integer DEFAULT_GARAGE_SIZE = 2;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public String toString(){
        return "Imię: " + name+", Wynagrodzenie: "+salary+", Pieniądze na koncie: "+cash+", Samochód w garażu: "+garage;
    }
    public Human(String name) {
        this.name = name;
        this.cash = DEFAULT_CASH;
        this.salary = DEFAULT_SALARY;
        this.garage = new Car[DEFAULT_GARAGE_SIZE];
    }
    public Human(String name, Double salary, Double cash) {
        this.name = name;
        this.cash = cash;
        this.salary = salary;
        this.garage = new Car[DEFAULT_GARAGE_SIZE];
    }
    public Human(String name, Double salary, Double cash, Integer garageSize) {
        this.name = name;
        this.cash = cash;
        this.salary = salary;
        this.garage = new Car[garageSize];
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
    public void setCar(Car car,Integer parkingLotNumber) {
        if (parkingLotNumber >= this.garage.length) {
            System.out.println("Masz niewystarczająco miejsca w garażu.");
        } else if (parkingLotNumber < 0) {
            System.out.println("Nie masz garażu. Samochód musisz trzymać w garażu.");
        } else if (this.garage[parkingLotNumber] != null) {
            System.out.println("To miejsce w garażu jest zajęte.");
        } else {
            if (salary > car.value) {
                System.out.println("Gratulacje! Kupiłeś samochód za gotówkę.");
                this.garage[parkingLotNumber] = car;
            } else if (salary > (car.value / 12)) {
                System.out.println("Gratulacje! Kupiłeś samochód w kredo.");
                this.garage[parkingLotNumber] = car;
            } else {
                System.out.println("Nie stać Cię na auto. Pozostaje Ci je ukraść.");
            }
        }

    }
    public Double getValueOfAllCars() {
        Double valueOfCars = 0.0;
        for (int i = 0; i < this.garage.length; i++) {
            if (this.garage[i] != null) {
                valueOfCars += this.garage[i].value;
            }
        }
        return valueOfCars;
    }
    public Car getCar(Integer parkingLotNumber) {
        return this.garage[parkingLotNumber];
    }
    public Phone setPhone(Phone phone) {
        return this.phone = phone;
    }
    public Phone getPhone() {
        return this.phone;
    }
    public Animal setAnimal(Animal animal) {
        return this.animal = animal;
    }
    public Animal getAnimal() {
        return this.animal;
    }

    public Double getCash() {
        return this.cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }
    public String getName()
    {
        return this.name;
    }
    public void sell(Human seller, Human buyer, Double price) {
        System.out.println("Handel ludźmi jest zabroniony. Policja już jedzie.");
    }

}
