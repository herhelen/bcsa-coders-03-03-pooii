package domain.vehicle;

import java.math.BigDecimal;

public class SUV extends Vehicle {

    public SUV(Integer id, String licensePlate, String maker, String color) {
        super(id, licensePlate, new BigDecimal(200.0), maker, color);
    }

    public SUV(String licensePlate, String maker, String color) {
        super(licensePlate, new BigDecimal(200.0), maker, color);
    }

    @Override
    public String toString() {
        return "SUV{" +
            super.toString() +
            "}";
    }
}
