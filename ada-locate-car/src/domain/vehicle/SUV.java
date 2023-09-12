package domain.vehicle;

import java.math.BigDecimal;

public class SUV extends Vehicle {

    public SUV(Integer id, String licensePlate, String maker, String year) {
        super(id, licensePlate, new BigDecimal(200.0), maker, year);
    }

    public SUV(String licensePlate, String maker, String year) {
        super(licensePlate, new BigDecimal(200.0), maker, year);
    }

    @Override
    public String toString() {
        return "SUV{" +
            super.toString() +
            "}";
    }
}
