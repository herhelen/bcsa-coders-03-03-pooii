package service.customer;

import domain.customer.Customer;
import domain.vehicle.Vehicle;
import repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class FindCustomerService {

    private final Repository<Customer> customerRepository;

    public FindCustomerService(Repository<Customer> customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    public Customer findById(Integer id) {
        for(Customer customer: this.findAll()) {
            if(customer.getId() == id) {
                return customer;
            }
        }
        return null; // TODO: Exception?
    }
}