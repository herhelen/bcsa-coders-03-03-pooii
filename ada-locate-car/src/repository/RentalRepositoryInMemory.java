package repository;

import domain.rental.Rental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RentalRepositoryInMemory implements Repository<Rental> {

    private static int COUNTER_RENTAL_ID;
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
        object.setId(++this.COUNTER_RENTAL_ID);
        this.rentals.add(object);
        return object;
    }

    @Override
    public Rental update(Rental object) {
        Rental old = this.findOne(object.getId());
        this.rentals.remove(old);
        this.rentals.add(object);
        return object;
    }
}
