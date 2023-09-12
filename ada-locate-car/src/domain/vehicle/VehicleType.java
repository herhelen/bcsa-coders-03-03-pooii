package domain.vehicle;

import java.math.BigDecimal;

public enum VehicleType {

    SMALL("Small", new BigDecimal(100.0)),
    MEDIUM("Medium", new BigDecimal(150.0)),
    SUV("SUV", new BigDecimal(200.0));

    private final String type;
    private final BigDecimal dailyRate;

    VehicleType(String type, BigDecimal dailyRate) {
        this.type = type;
        this.dailyRate = dailyRate;
    }

    public String getType() {
        return this.type;
    }

    public BigDecimal getDailyRate() {
        return this.dailyRate;
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "type='" + this.type + '\'' +
                ", dailyRate=" + String.format("%.2f", this.dailyRate) +
                "}";
    }
}
