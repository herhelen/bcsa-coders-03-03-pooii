package service.vehicle;

import domain.vehicle.Vehicle;
import domain.vehicle.VehicleType;
import repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class RegisterVehicleService {

    private final Repository<Vehicle> vehicleRepository;
    private final FindVehicleService findVehicleService;

    public RegisterVehicleService(Repository<Vehicle> vehicleRepository, FindVehicleService findVehicleService) {
        this.vehicleRepository = vehicleRepository;
        this.findVehicleService = findVehicleService;
    }

    public Vehicle register(VehicleType type, String licensePlate, String maker, String year) {
        if(this.isUniqueLicensePlate(licensePlate)) {
            Vehicle car = new Vehicle(type, licensePlate, maker, year, true);
            return this.vehicleRepository.create(car);
        }

        return null;
    }

    private boolean isUniqueLicensePlate(String licensePlate) {
        List temp = this.findVehicleService.findAll()
                .stream()
                .filter(element -> element.getLicensePlate().equalsIgnoreCase(licensePlate))
                .collect(Collectors.toList());

        return (temp.size() == 0);
    }
}
