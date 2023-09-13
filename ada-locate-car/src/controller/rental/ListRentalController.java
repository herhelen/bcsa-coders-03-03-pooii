package controller.rental;

import domain.rental.Rental;
import service.customer.FindCustomerService;
import service.rental.FindRentalService;
import service.vehicle.FindVehicleService;

import java.util.List;

public class ListRentalController {

    public static void listUnreturnedVehicle(FindRentalService findRentalService,
                                             FindCustomerService findCustomerService,
                                             FindVehicleService findVehicleService) {

        System.out.println("Os veículos alugados a devolver são:");

        System.out.println(String.format("%5s %15s %15s %15s", "id", "cliente", "placa", "ínicio aluguel"));

        for (Rental rental : findRentalService.findUnreturnedRental()) {
            System.out.println(String.format("%5d %15s %15s %15s",
                    rental.getId(),
                    findCustomerService.findById(rental.getIdCustomer()).getName(),
                    findVehicleService.findById(rental.getIdVehicle()).getLicensePlate(),
                    rental.getStartDateTime()));
        }
        System.out.println();

    }

    public static boolean hasRental(FindRentalService findRentalService) {
        return !findRentalService.findAll().isEmpty();
    }

    public static boolean hasUnreturnedRental(FindRentalService findRentalService) {
        return !findRentalService.findUnreturnedRental().isEmpty();
    }
}
