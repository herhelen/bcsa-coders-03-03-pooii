package domain.vehicle;

public class Vehicle {
    private Integer id;
    private VehicleType type;
    private String licensePlate;
    private String maker; //TODO: enum?
    private String year;
    private boolean isAvailable;

    public Vehicle(VehicleType type, String licensePlate, String maker, String year, boolean isAvailable) {
        this.type = type;
        this.licensePlate = licensePlate;
        this.maker = maker;
        this.year = year;
        this.isAvailable = isAvailable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VehicleType getType() {
        return this.type;
    }

    public String getLicensePlate() {
        return this.licensePlate;
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

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + this.id +
                ", type=" + this.type +
                ", licensePlate='" + this.licensePlate + '\'' +
                ", maker='" + this.maker + '\'' +
                ", year='" + this.year + '\'' +
                ", isAvailable='" + this.isAvailable + '\'' +
                "}";
    }
}
