package repository;

import domain.client.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientRepositoryInMemory implements Repository<Client> {

    private static List<Client> rentals;

    public ClientRepositoryInMemory() {
        this.rentals = new ArrayList<>();
    }

    @Override
    public Client findOne(int id) {
        for(Object obj : this.rentals) {
            if(obj instanceof Client) {
                Client rental = (Client) obj;
                if(rental.getId() == id) {
                    return rental;
                }
            }
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        return Collections.unmodifiableList(this.rentals);
    }

    @Override
    public Client create(Client object) {
        this.rentals.add(object);
        return object;
    }

    @Override
    public void delete(Client object) {
        throw new RuntimeException("Ainda não implementado");
        // TODO
    }

    @Override
    public Client update(Client object) {
        throw new RuntimeException("Ainda não implementado");
//        return null;
    }
}
