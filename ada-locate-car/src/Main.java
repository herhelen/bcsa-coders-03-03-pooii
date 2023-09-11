import domain.client.Client;
import domain.client.Company;
import domain.client.Person;
import domain.rental.Rental;
import domain.vehicle.Medium;
import domain.vehicle.SUV;
import domain.vehicle.Small;
import domain.vehicle.Vehicle;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        Vehicle teste = new Medium(1, "AAA1234", "Nissan", "Azul");
        System.out.println(teste);

        Client teste2 = new Person(1, "CPF", "Nome 1");
        System.out.println(teste2);

        Rental rent = new Rental(1, 1, 1);
        rent.setStartDatetime(LocalDateTime.of(2023, 9, 11, 14, 44, 45));
        System.out.println(rent);
        rent.setEndDatetime(LocalDateTime.of(2023, 9, 12, 14, 44, 45));
        System.out.println(rent);
    }
}