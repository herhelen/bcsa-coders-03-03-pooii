package domain.client;

public class Person extends Client {

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
