package repository;

import domain.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleRepositoryInMemory implements Repository<Vehicle> {

    private static List<Vehicle> vehicles;

    public VehicleRepositoryInMemory() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public Vehicle findOne(int id) {
        for(Object obj : this.vehicles) {
            if(obj instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) obj;
                if(vehicle.getId() == id) {
                    return vehicle;
                }
            }
        }
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        return Collections.unmodifiableList(this.vehicles);
    }

    @Override
    public Vehicle create(Vehicle object) {
        this.vehicles.add(object);
        return object;
    }

    @Override
    public void delete(Vehicle object) {
        throw new RuntimeException("Ainda não implementado");
        // TODO
    }

    @Override
    public Vehicle update(Vehicle object) {
        throw new RuntimeException("Ainda não implementado");
//        return null;
    }
}