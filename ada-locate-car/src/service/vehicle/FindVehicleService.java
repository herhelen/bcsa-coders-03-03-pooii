package service.vehicle;

import domain.vehicle.Vehicle;
import repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class FindVehicleService {

    private final Repository<Vehicle> vehicleRepository;

    public FindVehicleService(Repository<Vehicle> vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAll() {
        return this.vehicleRepository.findAll();
    }

    public List<Vehicle> findByPartialLicensePlate(String partialLicensePlate) {
        List temp = this.findAll()
                .stream()
                .filter(element -> element.getLicensePlate().toLowerCase().contains(partialLicensePlate.toLowerCase()))
                .collect(Collectors.toList());
        return temp;
    }

    public List<Vehicle> findAvailableVehicle() {
        return this.findAll()
                .stream()
                .filter(element -> element.isAvailable() == true)
                .collect(Collectors.toList());
    }

    public Vehicle findById(Integer id) {
        for(Vehicle vehicle: this.findAll()) {
            if(vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }
}
