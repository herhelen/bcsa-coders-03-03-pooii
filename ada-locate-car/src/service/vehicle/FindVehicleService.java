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
        // TODO: verificar se é null partialLicensePlate
        List temp = this.findAll()
                .stream()
                .filter(element -> element.getLicensePlate().toLowerCase().contains(partialLicensePlate.toLowerCase()))
                .collect(Collectors.toList());
        return temp;
    }

    public Vehicle findById(Integer id) {
        for(Vehicle vehicle: this.findAll()) {
            if(vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null; // TODO: Exception?
    }
}
