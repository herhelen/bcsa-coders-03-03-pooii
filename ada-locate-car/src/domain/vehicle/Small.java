package domain.vehicle;

import java.math.BigDecimal;

public class Small extends Vehicle {

    public Small(Integer id, String licensePlate, String maker, String color) {
        super(id, licensePlate, new BigDecimal(100.0), maker, color);
    }

    public Small(String licensePlate, String maker, String color) {
        super(licensePlate, new BigDecimal(100.0), maker, color);
    }

    @Override
    public String toString() {
        return "Small{" +
            super.toString() +
            "}";
    }
}
