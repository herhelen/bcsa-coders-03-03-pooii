package service.rental;

import domain.rental.Rental;
import repository.Repository;
import service.vehicle.UpdateVehicleService;

import java.time.LocalDateTime;

public class ReturnRentalService {

    private final Repository<Rental> rentalRepository;
    private final UpdateVehicleService updateVehicleService;

    public ReturnRentalService(Repository<Rental> rentalRepository, UpdateVehicleService updateVehicleService) {
        this.rentalRepository = rentalRepository;
        this.updateVehicleService = updateVehicleService;
    }

    public Rental returnVehicle(Integer id, LocalDateTime endDateTime, String endPlace) {
        // TODO: Validar endPlace?
        Rental rental = this.rentalRepository.findOne(id);
        rental.setEndDateTime(endDateTime);
        rental.setEndPlace(endPlace);

        // TODO: calcular valor

        this.updateVehicleService.update(rental.getIdVehicle(), true);

        return this.rentalRepository.update(rental);
    }

}
