package service.rental;

import domain.rental.Rental;
import repository.Repository;

import java.util.List;

public class FindRentalService {

    private final Repository<Rental> rentalRepository;

    public FindRentalService(Repository<Rental> rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> findAll() {
        return this.rentalRepository.findAll();
    }

    public List<Rental> findByCustomer(Integer idCustomer, boolean isReturned) {
        return this.rentalRepository.findAll(); // TODO:?
    }

    public List<Rental> findByVehicle(Integer idVehicle, boolean isReturned) {
        return this.rentalRepository.findAll(); // TODO:?
    }

    public Rental findById(Integer id) {
        for(Rental rental: this.findAll()) {
            if(rental.getId() == id) {
                return rental;
            }
        }
        return null; // TODO: Exception?
    }

}
