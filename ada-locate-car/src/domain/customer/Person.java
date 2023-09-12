package domain.customer;

public class Person extends Customer {

    public Person(Integer id, String document, String name) {
        super(id, document, name, 5, 0.05);
    }

    @Override
    public String toString() {
        return "Person{" +
            super.toString() +
            "}";
    }
}
