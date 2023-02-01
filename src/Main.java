import creatures.Human;
import devices.Application;
import devices.Electric;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        Phone samsung = new Phone("Samsung", "M52", 2022);
        Human bartek = new Human("Bartek", 7000.0, 6000.0, 2);
        bartek.setPhone(samsung);
        Application chrome = new Application("Chrome", "1.0");
        Application mozilla = new Application("Mozilla", 5.0, "2.0");
        Application brave = new Application("Brave", 555.0, "2.0");
        Application edge = new Application("Edge", 10000.0,"3.0");
        System.out.println(bartek);
        System.out.println(samsung);
        System.out.println(chrome);
        System.out.println(mozilla);
        System.out.println(edge);
        System.out.println(brave);
        System.out.println("Twój stan konta przed zakupem aplikacji: "+bartek.getCash());
        samsung.installAnApp(bartek, chrome);
        samsung.installAnApp(bartek, mozilla);
        samsung.installAnApp(bartek, brave);
        samsung.installAnApp(bartek, edge);
        System.out.println("Twój stan konta po zakupie aplikacji: "+bartek.getCash());
        System.out.println("Lista Twoich darmowych aplikacji na telefonie: "+samsung.showFreeApps());
        System.out.println("Czy aplikacja Chrome jest zainstalowana: "+samsung.isInstalled(chrome));
        System.out.println("Czy aplikacja Edge jest zainstalowana: "+samsung.isInstalled(edge));
        System.out.println("Lista Twoich aplikacji na telefonie posortowana po cenie: "+samsung.getInstalledAppsByPrice());
        System.out.println("Lista Twoich aplikacji na telefonie posortowana po nazwie: "+samsung.getInstalledAppsAlphabetically());
        System.out.println("Łączna wartość zainstalowanych aplikacji: "+samsung.getAllAppsValue());
    }
}
