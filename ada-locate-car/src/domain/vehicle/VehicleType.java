package domain.vehicle;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum VehicleType {

    SMALL(1, "Pequeno", new BigDecimal(100.0)),
    MEDIUM(2, "Médio", new BigDecimal(150.0)),
    SUV(3, "SUV", new BigDecimal(200.0));

    private final Integer id;
    private final String type;
    private final BigDecimal dailyRate;

    VehicleType(Integer id, String type, BigDecimal dailyRate) {
        this.id = id;
        this.type = type;
        this.dailyRate = dailyRate;
    }

    public Integer getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public BigDecimal getDailyRate() {
        return this.dailyRate;
    }

    public static VehicleType idToEnum(int id) {
        for(VehicleType type : values()) {
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
        return "VehicleType{" +
                "type='" + this.type + '\'' +
                ", dailyRate=" + String.format("%.2f", this.dailyRate) +
                "}";
    }
}
