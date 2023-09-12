package domain.customer;

public enum CustomerType {

    COMPANY("Company", 3, 0.10),
    PERSON("Person", 5, 0.05);

    private final String type;
    private final Integer minDaysForDiscount;
    private final Double discountPercentage;

    CustomerType(String type, Integer minDaysForDiscount, Double discountPercentage) {
        this.type = type;
        this.minDaysForDiscount = minDaysForDiscount;
        this.discountPercentage = discountPercentage;
    }

    public String getType() {
        return this.type;
    }

    public Integer getMinDaysForDiscount() {
        return this.minDaysForDiscount;
    }

    public Double getDiscountPercentage() {
        return this.discountPercentage;
    }

    @Override
    public String toString() {
        return "CustomerType{" +
                "type='" + this.type + '\'' +
                ", minDaysForDiscount=" + this.minDaysForDiscount +
                ", discountPercentage=" + String.format("%.2f", this.discountPercentage) +
                "}";
    }
}
