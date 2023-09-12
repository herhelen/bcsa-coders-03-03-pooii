package domain.customer;

public abstract class Customer {
    private Integer id;
    private String document;
    private String name;
    private Integer minDaysForDiscount;
    private Double discountPercentage;

    public Customer(Integer id, String document, String name, Integer minDaysForDiscount, Double discountPercentage) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.minDaysForDiscount = minDaysForDiscount;
        this.discountPercentage = discountPercentage;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDocument() {
        return this.document;
    }

    public String getName() {
        return this.name;
    }

    public Integer getMinDaysForDiscount() {
        return this.minDaysForDiscount;
    }

    public Double getDiscountPercentage() {
        return this.discountPercentage;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + this.id +
                ", document='" + this.document + '\'' +
                ", name='" + this.name + '\'' +
                ", minDaysForDiscount=" + this.minDaysForDiscount +
                ", discountPercentage=" + String.format("%.2f", this.discountPercentage) +
                '}';
    }
}
