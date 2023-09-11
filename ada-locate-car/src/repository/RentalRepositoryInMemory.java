package repository;

import domain.rental.Rental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RentalRepositoryInMemory implements Repository<Rental> {

    private static List<Rental> rentals;

    public RentalRepositoryInMemory() {
        this.rentals = new ArrayList<>();
    }

    @Override
    public Rental findOne(int id) {
        for(Object obj : this.rentals) {
            if(obj instanceof Rental) {
                Rental rental = (Rental) obj;
                if(rental.getId() == id) {
                    return rental;
                }
            }
        }
        return null;
    }

    @Override
    public List<Rental> findAll() {
        return Collections.unmodifiableList(this.rentals);
    }

    @Override
    public Rental create(Rental object) {
        this.rentals.add(object);
        return object;
    }

    @Override
    public void delete(Rental object) {
        throw new RuntimeException("Ainda não implementado");
        // TODO
    }

    @Override
    public Rental update(Rental object) {
        throw new RuntimeException("Ainda não implementado");
//        return null;
    }
}