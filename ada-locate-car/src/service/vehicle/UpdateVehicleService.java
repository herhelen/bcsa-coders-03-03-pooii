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

        if(vehicle != null) {
            vehicle.setMaker(maker);
            vehicle.setYear(year);
            return this.vehicleRepository.update(vehicle);
        }

        return null;
    }

    public Vehicle update(Integer id, boolean isAvailable) {
        Vehicle vehicle = this.findVehicleService.findById(id);
        vehicle.setAvailable(isAvailable);

        return this.vehicleRepository.update(vehicle);
    }
}
