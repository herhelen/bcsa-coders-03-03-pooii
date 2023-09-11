package domain.client;

public class Company extends Client {

    public Company(Integer id, String document, String name) {
        super(id, document, name, 3, 0.1);
    }

    @Override
    public String toString() {
        return "Company{" +
            super.toString() +
            "}";
    }
}
