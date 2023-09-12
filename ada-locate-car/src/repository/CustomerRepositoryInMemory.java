package repository;

import domain.customer.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRepositoryInMemory implements Repository<Customer> {

    private static List<Customer> rentals;

    public CustomerRepositoryInMemory() {
        this.rentals = new ArrayList<>();
    }

    @Override
    public Customer findOne(int id) {
        for(Object obj : this.rentals) {
            if(obj instanceof Customer) {
                Customer rental = (Customer) obj;
                if(rental.getId() == id) {
                    return rental;
                }
            }
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return Collections.unmodifiableList(this.rentals);
    }

    @Override
    public Customer create(Customer object) {
        this.rentals.add(object);
        return object;
    }

    @Override
    public void delete(Customer object) {
        throw new RuntimeException("Ainda não implementado");
        // TODO
    }

    @Override
    public Customer update(Customer object) {
        throw new RuntimeException("Ainda não implementado");
//        return null;
    }
}
