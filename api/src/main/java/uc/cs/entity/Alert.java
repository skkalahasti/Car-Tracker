package uc.cs.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Alert.findAll",query = "SELECT alert FROM Alert alert"),
        @NamedQuery(name = "Alert.findByPriority",query = "SELECT alert FROM Alert alert WHERE alert.priority=:parampriority"),
        @NamedQuery(name = "Alert.findByVin",query = "SELECT alert FROM Alert alert WHERE alert.vin=:paramvin"),
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Alert.findByPriorityandtime", query="SELECT alert FROM Alert alert WHERE (alert.priority=:parampriority AND DATE_ADD(alert.timestamp, INTERVAL u:paramtime HOUR) >= now())")
})
public class Alert {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(columnDefinition = "VARCHAR(30)")
    private String type;
    @Column(columnDefinition = "VARCHAR(10)")
    private String priority;
    @Column(columnDefinition = "VARCHAR(50)")
    private String vin;
    private Timestamp timestamp;

    public Alert(){
        this.id=UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", priority='" + priority + '\'' +
                ", vin='" + vin + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
