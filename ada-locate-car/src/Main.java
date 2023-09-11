import domain.client.Client;
import domain.client.Company;
import domain.client.Person;
import domain.rental.Rental;
import domain.vehicle.Medium;
import domain.vehicle.SUV;
import domain.vehicle.Small;
import domain.vehicle.Vehicle;
import repository.VehicleRepositoryInMemory;
import service.VehicleService;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        VehicleService vs = new VehicleService(new VehicleRepositoryInMemory());
        vs.createSUV("AAA123", "SUV", "Azul");
        vs.createMedium("AAA124", "Medium", "Azul");
        vs.createSmall("AAA125", "Small", "Azul");

        System.out.println(vs.listAll());


        Client teste2 = new Person(1, "CPF", "Nome 1");
        System.out.println(teste2);

        Rental rent = new Rental(1, 1, 1);
        rent.setStartDatetime(LocalDateTime.of(2023, 9, 11, 14, 44, 45));
        System.out.println(rent);
        rent.setEndDatetime(LocalDateTime.of(2023, 9, 12, 14, 44, 45));
        System.out.println(rent);
    }
}