package domain.rental;

import java.time.LocalDateTime;

public class Rental {
    private Integer id;
    private Integer idVehicle;
    private Integer idClient;
    private LocalDateTime startDatetime;
    private LocalDateTime endDatetime;

    public Rental(Integer id, Integer idVehicle, Integer idClient) {
        this.id = id;
        this.idVehicle = idVehicle;
        this.idClient = idClient;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getIdVehicle() {
        return this.idVehicle;
    }

    public Integer getIdClient() {
        return this.idClient;
    }

    public LocalDateTime getStartDatetime() {
        return this.startDatetime;
    }

    public void setStartDatetime(LocalDateTime startDatetime) {
        this.startDatetime = startDatetime;
    }

    public LocalDateTime getEndDatetime() {
        return this.endDatetime;
    }

    public void setEndDatetime(LocalDateTime endDatetime) {
        this.endDatetime = endDatetime;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + this.id +
                ", idVehicle=" + this.idVehicle +
                ", idClient=" + this.idClient +
                ", startDatetime=" + this.startDatetime +
                ", endDatetime=" + this.endDatetime +
                '}';
    }
}