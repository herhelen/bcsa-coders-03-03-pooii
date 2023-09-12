package repository;

import domain.customer.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRepositoryInMemory implements Repository<Customer> {

    private static int COUNTER_CUSTOMER_ID;
    private static List<Customer> customers;

    public CustomerRepositoryInMemory() {
        this.customers = new ArrayList<>();
    }

    @Override
    public Customer findOne(int id) {
        for(Object obj : this.customers) {
            if(obj instanceof Customer) {
                Customer customer = (Customer) obj;
                if(customer.getId() == id) {
                    return customer;
                }
            }
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return Collections.unmodifiableList(this.customers);
    }

    @Override
    public Customer create(Customer object) {
        object.setId(++this.COUNTER_CUSTOMER_ID);
        this.customers.add(object);
        return object;
    }

    @Override
    public Customer update(Customer object) {
        Customer old = this.findOne(object.getId());
        this.customers.remove(old);
        this.customers.add(object);
        return object;
    }
}
