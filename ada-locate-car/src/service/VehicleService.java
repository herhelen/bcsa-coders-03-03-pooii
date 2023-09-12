package service;

import domain.vehicle.Vehicle;
import domain.vehicle.VehicleType;
import repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleService {

    private Repository<Vehicle> vehicleRepository;

    public VehicleService(Repository<Vehicle> vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public int create(VehicleType type, String licensePlate, String maker, String year) {
        if(this.isUniqueLicensePlate(licensePlate)) {
            Vehicle car = new Vehicle(type, licensePlate, maker, year);
            this.vehicleRepository.create(car);

            return car.getId();
        }
        return -1; //TODO: Exception?
    }

    public List<Vehicle> listAll() {
        return this.vehicleRepository.findAll();
    }

    public List<Vehicle> findByPartialLicensePlate(String partialLicensePlate) {
        List temp = this.listAll()
                .stream()
                .filter(element -> element.getLicensePlate().toLowerCase().contains(partialLicensePlate.toLowerCase()))
                .collect(Collectors.toList());
        return temp;
    }

    private boolean isUniqueLicensePlate(String licensePlate) {
        List temp = this.listAll()
            .stream()
            .filter(element -> element.getLicensePlate().equalsIgnoreCase(licensePlate))
            .collect(Collectors.toList());

        return (temp.size() == 0);
    }
}
