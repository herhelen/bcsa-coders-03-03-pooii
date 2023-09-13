package service.rental;

import domain.rental.Rental;
import domain.vehicle.Vehicle;
import repository.Repository;
import service.vehicle.FindVehicleService;
import service.vehicle.UpdateVehicleService;

import java.time.LocalDateTime;

public class RentRentalService {

    private final Repository<Rental> rentalRepository;
    private final FindVehicleService findVehicleService;
    private final UpdateVehicleService updateVehicleService;

    public RentRentalService(Repository<Rental> rentalRepository, FindVehicleService findVehicleService,
                             UpdateVehicleService updateVehicleService) {
        this.rentalRepository = rentalRepository;
        this.findVehicleService = findVehicleService;
        this.updateVehicleService = updateVehicleService;
    }

    public Rental rent(Integer idVehicle, Integer idCustomer, LocalDateTime startDateTime, String startPlace) {
        Vehicle vehicle = this.findVehicleService.findById(idVehicle);

        if(vehicle.isAvailable()) {
            Rental rental = new Rental(idVehicle, idCustomer, startDateTime, startPlace);
            this.updateVehicleService.update(idVehicle, false);

            return this.rentalRepository.create(rental);
        }
        return null;
    }

}
