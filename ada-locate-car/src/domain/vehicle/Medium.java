package domain.vehicle;

import java.math.BigDecimal;

public class Medium extends Vehicle {

    public Medium(Integer id, String licensePlate, String maker, String year) {
        super(id, licensePlate, new BigDecimal(150.0), maker, year);
    }

    public Medium(String licensePlate, String maker, String year) {
        super(licensePlate, new BigDecimal(150.0), maker, year);
    }

    @Override
    public String toString() {
        return "Medium{" +
            super.toString() +
            "}";
    }
}
