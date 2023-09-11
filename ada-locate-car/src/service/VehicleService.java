package service;

import domain.vehicle.Medium;
import domain.vehicle.SUV;
import domain.vehicle.Small;
import domain.vehicle.Vehicle;
import repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleService {

    private static int COUNTER_MOVIE_ID;
    private Repository<Vehicle> vehicleRepository;

    public VehicleService(Repository<Vehicle> vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public int createSmall(String licensePlate, String maker, String color) {
        if(this.isUniqueLicensePlate(licensePlate)) {
            Vehicle car = new Small(licensePlate, maker, color);
            this.vehicleRepository.create(car);

            return car.getId();
        }
        return -1; //TODO: Exception?
    }

    public int createMedium(String licensePlate, String maker, String color) {
        if(this.isUniqueLicensePlate(licensePlate)) {
            Vehicle car = new Medium(licensePlate, maker, color);
            this.vehicleRepository.create(car);

            return car.getId();
        }
        return -1; //TODO: Exception?
    }

    public int createSUV(String licensePlate, String maker, String color) {
        if(this.isUniqueLicensePlate(licensePlate)) {
            Vehicle car = new SUV(licensePlate, maker, color);
            this.vehicleRepository.create(car);

            return car.getId();
        }
        return -1; //TODO: Exception?
    }

    public List<Vehicle> listAll() {
        return this.vehicleRepository.findAll();
    }

    private boolean isUniqueLicensePlate(String licensePlate) {
        List temp = this.listAll()
            .stream()
            .filter(element -> element.getLicensePlate().equalsIgnoreCase(licensePlate))
            .collect(Collectors.toList());

        return (temp.size() == 0);
    }
}
