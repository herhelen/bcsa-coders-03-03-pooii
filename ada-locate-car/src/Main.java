import domain.customer.Customer;
import domain.customer.CustomerType;
import domain.rental.Rental;
import domain.vehicle.VehicleType;
import repository.VehicleRepositoryInMemory;
import service.VehicleService;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        VehicleService vs = new VehicleService(new VehicleRepositoryInMemory());
        vs.create(VehicleType.SUV, "AAA123", "SUV", "2020");
        vs.create(VehicleType.MEDIUM,"AAA124", "Medium", "2023");
        vs.create(VehicleType.SMALL,"AAA125", "Small", "2010");

        System.out.println(vs.listAll());

        System.out.println(vs.findByPartialLicensePlate("AAA"));

        System.out.println(vs.findByPartialLicensePlate("23"));

        Customer teste2 = new Customer(CustomerType.PERSON, "CPF", "Nome 1");
        System.out.println(teste2);

        Rental rent = new Rental(1, 1);
        rent.setStartDateTime(LocalDateTime.of(2023, 9, 11, 14, 44, 45));
        rent.setStartPlace("Loja 1");
        System.out.println(rent);
        rent.setEndDateTime(LocalDateTime.of(2023, 9, 12, 14, 44, 45));
        rent.setEndPlace("Loja 2");
        System.out.println(rent);
    }
}