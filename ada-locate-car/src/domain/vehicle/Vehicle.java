package domain.vehicle;

import java.math.BigDecimal;

public abstract class Vehicle {
    private Integer id;
    private String licensePlate;
    private BigDecimal dailyRate;
    private String maker; //TODO: enum?
    private String year;

    public Vehicle(Integer id, String licensePlate, BigDecimal dailyRate, String maker, String year) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.dailyRate = dailyRate;
        this.maker = maker;
        this.year = year;
    }

    public Vehicle(String licensePlate, BigDecimal dailyRate, String maker, String year) {
        this.licensePlate = licensePlate;
        this.dailyRate = dailyRate;
        this.maker = maker;
        this.year = year;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public BigDecimal getDailyRate() {
        return this.dailyRate;
    }

    public String getMaker() {
        return this.maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + this.id +
                ", licensePlate='" + this.licensePlate + '\'' +
                ", dailyRate=" + String.format("%.2f", this.dailyRate) +
                ", maker='" + this.maker + '\'' +
                ", year='" + this.year + '\'' +
                "}";
    }
}
