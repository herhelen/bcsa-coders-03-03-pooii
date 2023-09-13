package domain.customer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CustomerType {

    COMPANY(1, "Company", 3, 0.10),
    PERSON(2, "Person", 5, 0.05);

    private final Integer id;
    private final String type;
    private final Integer minDaysForDiscount;
    private final Double discountPercentage;

    CustomerType(Integer id, String type, Integer minDaysForDiscount, Double discountPercentage) {
        this.id = id;
        this.type = type;
        this.minDaysForDiscount = minDaysForDiscount;
        this.discountPercentage = discountPercentage;
    }

    public Integer getId() {
        return this.id;
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

    public static CustomerType idToEnum(int id) {
        for(CustomerType type : values()) {
            if(type.getId() == id) {
                return type;
            }
        }
        return null;
    }

    public static List<Integer> ids() {
        return Arrays.stream(values())
                .map(element -> element.getId())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "CustomerType{" +
                "type='" + this.type + "'" +
                ", minDaysForDiscount=" + this.minDaysForDiscount +
                ", discountPercentage=" + String.format("%.2f", this.discountPercentage) +
                "}";
    }
}
