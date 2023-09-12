package service.vehicle;

import domain.vehicle.Vehicle;
import repository.Repository;


public class UpdateVehicleService {

    private final Repository<Vehicle> vehicleRepository;
    private final FindVehicleService findVehicleService;

    public UpdateVehicleService(Repository<Vehicle> vehicleRepository, FindVehicleService findVehicleService) {
        this.vehicleRepository = vehicleRepository;
        this.findVehicleService = findVehicleService;
    }

    public Vehicle update(Integer id, String maker, String year) {

        Vehicle vehicle = this.findVehicleService.findById(id);

        if(year == null || year.isBlank()) { // TODO: Utils?
            // TODO: Exception?
        } else {
            vehicle.setYear(year);
        }

        if(maker == null || maker.isBlank()) {
            // TODO: Exception?
        } else {
            vehicle.setMaker(maker);
        }

        return this.vehicleRepository.update(vehicle);
    }

}
