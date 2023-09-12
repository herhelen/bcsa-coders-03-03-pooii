package service.rental;

import domain.rental.Rental;
import repository.Repository;
import service.vehicle.UpdateVehicleService;

import java.time.LocalDateTime;

public class RentRentalService {

    private final Repository<Rental> rentalRepository;
    private final UpdateVehicleService updateVehicleService;

    public RentRentalService(Repository<Rental> rentalRepository, UpdateVehicleService updateVehicleService) {
        this.rentalRepository = rentalRepository;
        this.updateVehicleService = updateVehicleService;
    }

    public Rental rent(Integer idVehicle, Integer idCustomer, LocalDateTime startDateTime, String startPlace) {
        // TODO: Verificar se o veiculo ta disponivel?
        Rental rental = new Rental(idVehicle, idCustomer, startDateTime, startPlace);
        this.updateVehicleService.update(idVehicle, false);

        return this.rentalRepository.create(rental);
    }

}
