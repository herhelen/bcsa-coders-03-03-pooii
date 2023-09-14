package service.rental;

import domain.customer.Customer;
import domain.rental.Rental;
import domain.vehicle.Vehicle;
import repository.Repository;
import service.customer.FindCustomerService;
import service.vehicle.FindVehicleService;

import java.math.BigDecimal;
import java.time.Duration;

public class CalculateRentalService {

    private final Repository<Rental> rentalRepository;
    private final FindRentalService findRentalService;
    private final FindVehicleService findVehicleService;
    private final FindCustomerService findCustomerService;

    public CalculateRentalService(Repository<Rental> rentalRepository, FindRentalService findRentalService,
                                  FindVehicleService findVehicleService, FindCustomerService findCustomerService) {
        this.rentalRepository = rentalRepository;
        this.findRentalService = findRentalService;
        this.findVehicleService = findVehicleService;
        this.findCustomerService = findCustomerService;
    }

    public BigDecimal calculateFinalRental(Integer idRental) {

        Rental rental = this.findRentalService.findById(idRental);

        return this.calculateFinalRental(rental);
    }

    public BigDecimal calculateFinalRental(Rental rental) {

        Vehicle vehicle = this.findVehicleService.findById(rental.getIdVehicle());
        Customer customer = this.findCustomerService.findById(rental.getIdCustomer());

        long days = rentalDurationInDays(rental);
        BigDecimal finalRental = vehicle.getType().getDailyRate();
        finalRental = finalRental.multiply(BigDecimal.valueOf(days));

        double discount = this.getDiscount(customer, days);
        finalRental = finalRental.multiply(BigDecimal.valueOf(1 - discount));

        return finalRental;
    }

    // TODO: CalculateRentalDurationService?
    private long rentalDurationInDays(Rental rental) {
        Duration duration = Duration.between(rental.getStartDateTime(), rental.getEndDateTime());
        long days = duration.toDays();

        if(duration.toHoursPart() > 0 || duration.toMinutesPart() > 0) {
            days++;
        }

        return days;
    }

    private double getDiscount(Customer customer, long durationDays) {
        if(durationDays > customer.getType().getMinDaysForDiscount()) {
            return customer.getType().getDiscountPercentage();
        }

        return 0;
    }
}
