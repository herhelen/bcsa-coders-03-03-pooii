import domain.customer.Customer;
import domain.customer.CustomerType;
import domain.rental.Rental;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleType;
import repository.CustomerRepositoryInMemory;
import repository.Repository;
import repository.VehicleRepositoryInMemory;
import service.customer.FindCustomerService;
import service.customer.RegisterCustomerService;
import service.customer.UpdateCustomerService;
import service.vehicle.FindVehicleService;
import service.vehicle.RegisterVehicleService;
import service.vehicle.UpdateVehicleService;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        Repository<Vehicle> vr = new VehicleRepositoryInMemory();

        FindVehicleService fvs = new FindVehicleService(vr);
        RegisterVehicleService rvs = new RegisterVehicleService(vr, fvs);
        UpdateVehicleService uvs = new UpdateVehicleService(vr, fvs);

        rvs.register(VehicleType.SUV, "AAA123", "SUV", "2020");
        rvs.register(VehicleType.MEDIUM,"AAA124", "Medium", "2023");
        rvs.register(VehicleType.SMALL,"AAA125", "Small", "2010");

        System.out.println(fvs.findAll());
        System.out.println(fvs.findByPartialLicensePlate("AAA"));
        System.out.println(fvs.findByPartialLicensePlate("23"));
        System.out.println(fvs.findById(1));
        System.out.println(fvs.findById(5));

        System.out.println(uvs.update(1, "Nissan", ""));
        System.out.println(fvs.findAll());

        Repository<Customer> cr = new CustomerRepositoryInMemory();

        FindCustomerService fcs = new FindCustomerService(cr);
        RegisterCustomerService rcs = new RegisterCustomerService(cr, fcs);
        UpdateCustomerService ucs = new UpdateCustomerService(cr, fcs);

        rcs.register(CustomerType.PERSON, "CPF123", "Nome 1");
        rcs.register(CustomerType.COMPANY, "CNPJ123", "Nome 2");

        System.out.println(fcs.findAll());
        System.out.println(fcs.findById(1));
        System.out.println(fcs.findById(5));

        System.out.println(ucs.update(1, "Novo Nome 1"));
        System.out.println(fcs.findAll());

        Rental rent = new Rental(1, 1);
        rent.setStartDateTime(LocalDateTime.of(2023, 9, 11, 14, 44, 45));
        rent.setStartPlace("Loja 1");
        System.out.println(rent);
        rent.setEndDateTime(LocalDateTime.of(2023, 9, 12, 14, 44, 45));
        rent.setEndPlace("Loja 2");
        System.out.println(rent);
    }
}