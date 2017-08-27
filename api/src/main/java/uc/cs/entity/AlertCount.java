package uc.cs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AlertCount {
    @Id
    private String vin;


    @Column(columnDefinition = "VARCHAR(36)")
    private int cnt;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "AlertCount{" +
                "vin='" + vin + '\'' +
                ", cnt=" + cnt +
                '}';
    }
}
