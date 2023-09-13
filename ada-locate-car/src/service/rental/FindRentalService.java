package service.rental;

import domain.rental.Rental;
import repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class FindRentalService {

    private final Repository<Rental> rentalRepository;

    public FindRentalService(Repository<Rental> rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> findAll() {
        return this.rentalRepository.findAll();
    }

    public List<Rental> findUnreturnedRental() {
        return this.findAll()
                .stream()
                .filter(element -> element.isReturned() == false)
                .collect(Collectors.toList());
    }

    public Rental findById(Integer id) {
        for(Rental rental: this.findAll()) {
            if(rental.getId() == id) {
                return rental;
            }
        }
        return null;
    }

}
