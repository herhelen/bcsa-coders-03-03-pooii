package domain.rental;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Rental {
    private Integer id;
    private Integer idVehicle;
    private Integer idCustomer;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String startPlace;
    private String endPlace;
    private boolean isReturned;
    private BigDecimal rentalCost;

    public Rental(Integer idVehicle, Integer idCustomer) {
        this.idVehicle = idVehicle;
        this.idCustomer = idCustomer;
    }

    public Rental(Integer idVehicle, Integer idCustomer, LocalDateTime startDateTime, String startPlace) {
        this.idVehicle = idVehicle;
        this.idCustomer = idCustomer;
        this.startDateTime = startDateTime;
        this.startPlace = startPlace;
        this.isReturned = false;
        this.rentalCost = null;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return this.startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return this.endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public boolean isReturned() {
        return this.isReturned;
    }

    public void setReturned(boolean returned) {
        this.isReturned = returned;
    }

    public BigDecimal getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(BigDecimal rentalCost) {
        this.rentalCost = rentalCost;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + this.id +
                ", idVehicle=" + this.idVehicle +
                ", idCustomer=" + this.idCustomer +
                ", startDateTime=" + this.startDateTime +
                ", endDateTime=" + this.endDateTime +
                ", startPlace='" + this.startPlace + "'" +
                ", endPlace='" + this.endPlace + "'" +
                ", isReturned=" + this.isReturned +
                "}";
    }
}
