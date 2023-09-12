package domain.customer;

public class Customer {
    private Integer id; // TODO: Integer ou int?
    private CustomerType type;
    private String document;
    private String name;

    public Customer(CustomerType type, String document, String name) {
        this.type = type;
        this.document = document;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocument() {
        return this.document;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + this.id +
                ", document='" + this.document + "'" +
                ", name='" + this.name + "'" +
                ", type=" + this.type +
                "}";
    }
}
