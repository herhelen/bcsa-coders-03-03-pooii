import controller.MenuController;
import domain.customer.Customer;
import domain.customer.CustomerType;
import domain.rental.Rental;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleType;
import repository.CustomerRepositoryInMemory;
import repository.RentalRepositoryInMemory;
import repository.Repository;
import repository.VehicleRepositoryInMemory;
import service.customer.FindCustomerService;
import service.customer.RegisterCustomerService;
import service.customer.UpdateCustomerService;
import service.rental.CalculateRentalService;
import service.rental.FindRentalService;
import service.rental.RentRentalService;
import service.rental.ReturnRentalService;
import service.vehicle.FindVehicleService;
import service.vehicle.RegisterVehicleService;
import service.vehicle.UpdateVehicleService;

import java.time.Duration;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        MenuController menuController = new MenuController();
        menuController.mainMenu();

//        Repository<Vehicle> vr = new VehicleRepositoryInMemory();
//
//        FindVehicleService fvs = new FindVehicleService(vr);
//        RegisterVehicleService rvs = new RegisterVehicleService(vr, fvs);
//        UpdateVehicleService uvs = new UpdateVehicleService(vr, fvs);
//
//        rvs.register(VehicleType.SUV, "AAA123", "SUV", "2020");
//        rvs.register(VehicleType.MEDIUM,"AAA124", "Medium", "2023");
//        rvs.register(VehicleType.SMALL,"AAA125", "Small", "2010");
//
//        System.out.println(fvs.findAll());
//        System.out.println(fvs.findByPartialLicensePlate("AAA"));
//        System.out.println(fvs.findByPartialLicensePlate("23"));
//        System.out.println(fvs.findById(1));
//        System.out.println(fvs.findById(5));
//
//        System.out.println(uvs.update(1, "Nissan", ""));
//        System.out.println(fvs.findAll());
//
//        Repository<Customer> cr = new CustomerRepositoryInMemory();
//
//        FindCustomerService fcs = new FindCustomerService(cr);
//        RegisterCustomerService rcs = new RegisterCustomerService(cr, fcs);
//        UpdateCustomerService ucs = new UpdateCustomerService(cr, fcs);
//
//        rcs.register(CustomerType.PERSON, "CPF123", "Nome 1");
//        rcs.register(CustomerType.COMPANY, "CNPJ123", "Nome 2");
//
//        System.out.println(fcs.findAll());
//        System.out.println(fcs.findById(1));
//        System.out.println(fcs.findById(5));
//
//        System.out.println(ucs.update(1, "Novo Nome 1"));
//        System.out.println(fcs.findAll());
//
//        Repository<Rental> rr = new RentalRepositoryInMemory();
//
//        FindRentalService frs = new FindRentalService(rr);
//        RentRentalService rrs = new RentRentalService(rr, uvs);
//        ReturnRentalService returnRentalService = new ReturnRentalService(rr, uvs);
//        CalculateRentalService calculateRentalService = new CalculateRentalService(rr, frs, fvs, fcs);
//
//        rrs.rent(1, 2,
//                LocalDateTime.of(2023, 9, 11, 14, 44, 0), "Loja 1");
//
//        System.out.println(frs.findAll());
//
//        returnRentalService.returnVehicle(1,
//                LocalDateTime.of(2023, 9, 17, 14, 44, 0), "Loja 2");
//
//        System.out.println(frs.findAll());
//
//        System.out.println(calculateRentalService.calculateFinalRental(1));

    }
}