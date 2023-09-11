import domain.client.Client;
import domain.client.Company;
import domain.client.Person;
import domain.vehicle.Medium;
import domain.vehicle.SUV;
import domain.vehicle.Small;
import domain.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {

        Vehicle teste = new Medium(1, "AAA1234", "Nissan", "Azul");
        System.out.println(teste);

        Client teste2 = new Person(1, "CPF", "Nome 1");
        System.out.println(teste2);
    }
}