package domain.vehicle;

public class Vehicle {
    private Integer id;
    private VehicleType type;
    private String licensePlate;
    private String maker; //TODO: enum?
    private String year;

    public Vehicle(VehicleType type, String licensePlate, String maker, String year) {
        this.type = type;
        this.licensePlate = licensePlate;
        this.maker = maker;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + this.id +
                ", type=" + this.type +
                ", licensePlate='" + this.licensePlate + '\'' +
                ", maker='" + this.maker + '\'' +
                ", year='" + this.year + '\'' +
                "}";
    }
}
