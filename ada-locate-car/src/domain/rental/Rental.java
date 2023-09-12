package domain.rental;

import java.time.LocalDateTime;

public class Rental {
    private Integer id;
    private Integer idVehicle;
    private Integer idCustomer;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String startPlace;
    private String endPlace;

    public Rental(Integer id, Integer idVehicle, Integer idCustomer) {
        this.id = id;
        this.idVehicle = idVehicle;
        this.idCustomer = idCustomer;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getIdVehicle() {
        return this.idVehicle;
    }

    public Integer getIdCustomer() {
        return this.idCustomer;
    }

    public LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return this.endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + this.id +
                ", idVehicle=" + this.idVehicle +
                ", idClient=" + this.idCustomer +
                ", startDatetime=" + this.startDateTime +
                ", endDatetime=" + this.endDateTime +
                ", startPlace=" + this.startPlace +
                ", endPlace=" + this.endPlace +
                '}';
    }
}
