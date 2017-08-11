package uc.cs.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicles.findAll",query = "SELECT vehicles FROM Vehicles vehicles"),
        @NamedQuery(name = "Vehicles.findByvin",query = "SELECT vehicles FROM Vehicles vehicles WHERE vehicles.vin=:paramvin"),
        @NamedQuery(name = "Vehicles.checkForAlerts",query = "SELECT vehicles FROM Vehicles vehicles WHERE vehicles.vin=:paramalertvin")
})

public class Vehicles {

    @Id
    @Column(columnDefinition = "VARCHAR(50)")
    private String vin;

    @Column(columnDefinition = "VARCHAR(50)")
    private String make;
    @Column(columnDefinition = "VARCHAR(50)")
    private String model;
    private int year;
    private float redlineRpm;
    private float maxFuelVolume;
    private Timestamp lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(float redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public float getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(float maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Timestamp getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Timestamp lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }


    @Override
    public String toString() {
        return "Vehicles{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", redlineRpm='" + redlineRpm + '\'' +
                ", maxFuelVolume='" + maxFuelVolume + '\'' +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                '}';
    }


}