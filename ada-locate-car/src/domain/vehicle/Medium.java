package domain.vehicle;

import java.math.BigDecimal;

public class Medium extends Vehicle {

    public Medium(Integer id, String licensePlate, String maker, String color) {
        super(id, licensePlate, new BigDecimal(150.0), maker, color);
    }

    public Medium(String licensePlate, String maker, String color) {
        super(licensePlate, new BigDecimal(150.0), maker, color);
    }

    @Override
    public String toString() {
        return "Medium{" +
            super.toString() +
            "}";
    }
}
