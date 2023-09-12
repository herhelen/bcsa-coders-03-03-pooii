package service.customer;

import domain.customer.Customer;
import domain.customer.CustomerType;
import repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class RegisterCustomerService {

    private final Repository<Customer> customerRepository;
    private final FindCustomerService findCustomerService;

    public RegisterCustomerService(Repository<Customer> customerRepository, FindCustomerService findCustomerService) {
        this.customerRepository = customerRepository;
        this.findCustomerService = findCustomerService;
    }

    public Customer register(CustomerType type, String document, String name) {
        if(this.isUniqueDocument(document)) {
            Customer customer = new Customer(type, document, name);
            return this.customerRepository.create(customer);
        }

        return null; //TODO: Exception?
    }

    private boolean isUniqueDocument(String document) {
        List temp = this.findCustomerService.findAll()
                .stream()
                .filter(element -> element.getDocument().equalsIgnoreCase(document))
                .collect(Collectors.toList());

        return (temp.size() == 0);
    }
}
