package service.rental;

import domain.rental.Rental;
import repository.Repository;
import service.vehicle.UpdateVehicleService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReturnRentalService {

    private final Repository<Rental> rentalRepository;
    private final CalculateRentalService calculateRentalService;
    private final UpdateVehicleService updateVehicleService;

    public ReturnRentalService(Repository<Rental> rentalRepository, CalculateRentalService calculateRentalService,
                               UpdateVehicleService updateVehicleService) {
        this.rentalRepository = rentalRepository;
        this.calculateRentalService = calculateRentalService;
        this.updateVehicleService = updateVehicleService;
    }

    public Rental returnVehicle(Integer id, LocalDateTime endDateTime, String endPlace) {
        Rental rental = this.rentalRepository.findOne(id);

        if(!rental.isReturned()) {
            rental.setEndDateTime(endDateTime);
            rental.setEndPlace(endPlace);
            rental.setReturned(true);

            BigDecimal rentalCost = this.calculateRentalService.calculateFinalRental(rental);
            rental.setRentalCost(rentalCost);

            this.updateVehicleService.update(rental.getIdVehicle(), true);

            return this.rentalRepository.update(rental);
        }
        return null;
    }

}
