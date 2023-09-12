package service.customer;

import domain.customer.Customer;
import repository.Repository;

public class UpdateCustomerService {

    private final Repository<Customer> customerRepository;
    private final FindCustomerService findCustomerService;

    public UpdateCustomerService(Repository<Customer> customerRepository, FindCustomerService findCustomerService) {
        this.customerRepository = customerRepository;
        this.findCustomerService = findCustomerService;
    }

    public Customer update(Integer id, String name) {

        Customer customer = this.findCustomerService.findById(id);

        if(name == null || name.isBlank()) { // TODO: Utils?
            // TODO: Exception?
        } else {
            customer.setName(name);
        }

        return this.customerRepository.update(customer);
    }
}
