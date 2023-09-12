package domain.vehicle;

import java.math.BigDecimal;

public class Small extends Vehicle {

    public Small(Integer id, String licensePlate, String maker, String year) {
        super(id, licensePlate, new BigDecimal(100.0), maker, year);
    }

    public Small(String licensePlate, String maker, String year) {
        super(licensePlate, new BigDecimal(100.0), maker, year);
    }

    @Override
    public String toString() {
        return "Small{" +
            super.toString() +
            "}";
    }
}
