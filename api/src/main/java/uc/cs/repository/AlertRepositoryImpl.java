package uc.cs.repository;

import org.springframework.stereotype.Repository;
import uc.cs.entity.Alert;
import uc.cs.entity.AlertCount;
import uc.cs.entity.Readings;
import uc.cs.entity.Vehicles;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Alert> findAll() {
        TypedQuery<Alert> query=entityManager.createNamedQuery("Alert.findAll",Alert.class);
        return query.getResultList();

    }

    public List<Object> findvincount() {

        String qlString = "SELECT count (a.vin), a.vin FROM Alert a where a.priority='HIGH' GROUP BY a.vin";
        Query q = entityManager.createQuery(qlString);
        List<Object> results = (List<Object>) q.getResultList();

        return results;

    }



    public List<AlertCount> findvincount(String time) {

        String qlString = "SELECT a.vin, count(a.vin) AS cnt FROM alert a WHERE (a.priority='HIGH' AND DATE_ADD(a.timestamp, INTERVAL "+time +" HOUR) >= now()) GROUP BY a.vin ORDER BY cnt DESC";
        Query query=entityManager.createNativeQuery(qlString,AlertCount.class);

        return (List<AlertCount>) query.getResultList();

    }

    public List<Alert> findByPriority(String priority) {

        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findByPriority",Alert.class);

        query.setParameter("parampriority", priority);
        List<Alert> resultList = query.getResultList();

        if (resultList != null) {
            return resultList;
        } else {
            return null;
        }

    }

    public List<Alert> findByPriorityandtime(String priority, String time) {

        String quer="SELECT * FROM alert a WHERE (a.priority='"+priority+"'AND DATE_ADD(a.timestamp, INTERVAL "+time +" HOUR) >= now())";

        System.out.println(quer);

        Query query = entityManager.createNativeQuery(quer,Alert.class);

        List<Alert> resultList=(List<Alert>)query.getResultList();

            return resultList;

    }
    public List<Alert> findByVin(String vin) {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findByVin",Alert.class);

        query.setParameter("paramvin", vin);
        List<Alert> resultList = query.getResultList();

        if (resultList != null) {
            return resultList;
        } else {
            return null;
        }
    }

    public List<Alert> findByVin(String vin, String time) {
        Query query = entityManager.createNativeQuery("SELECT * FROM alert a WHERE (a.vin='"+vin+"'AND a.priority='HIGH' AND DATE_ADD(a.timestamp, INTERVAL "+time +" HOUR) >= now())",Alert.class);

        List<Alert> resultList = (List<Alert>)query.getResultList();

            return resultList;
    }


    public void checkForAlerts(Readings readings){

        Alert alert=new Alert();

        boolean alert_defined=false;

        TypedQuery<Vehicles> query = entityManager.createNamedQuery("Vehicles.checkForAlerts",Vehicles.class);

        query.setParameter("paramalertvin", readings.getVin());

        List<Vehicles> resultList = query.getResultList();

        if (resultList != null && resultList.size()==1) {

            Vehicles vehicles=resultList.get(0);

            //Rule-1
            if(readings.getEngineRpm() > vehicles.getRedlineRpm()) {
                alert.setPriority("HIGH");
                alert.setType("RPM");
                alert_defined=true;
                String Category="RPM";
                // Sends an email for a High Alert.
                // Uncomment the below line and then provide details of gmail user id, password, From Email and To Email
                // ComposeEmail.SendEmail(vehicles.getVin(),Category);
            }
            else if(readings.getFuelVolume() < (0.1 * vehicles.getMaxFuelVolume())) {  // Rule 2
                alert.setPriority("MEDIUM");
                alert.setType("Fuel");
                alert_defined=true;
            }
            else if(readings.getTires().getFrontLeft() < 32 || readings.getTires().getFrontLeft() > 36 || // Rule 3
            readings.getTires().getFrontRight() < 32 || readings.getTires().getFrontRight() > 36 ||
            readings.getTires().getRearLeft() < 32 || readings.getTires().getRearLeft() > 36 ||
            readings.getTires().getRearRight() < 32 || readings.getTires().getRearRight() > 36 ){
                alert.setPriority("LOW");
                alert.setType("TirePressure");
                alert_defined=true;
            }
            else if(readings.isEngineCoolantLow()==true) { // Rule 4
            alert.setPriority("LOW");
            alert.setType("EngineCoolantLow");
                alert_defined=true;
            }
            else if( readings.isCheckEngineLightOn()==true) { //Rule 5
                alert.setPriority("LOW");
                alert.setType("EngineLight");
                alert_defined=true;
            }

            if(alert_defined) {   // Alert will be created only if it passes an alert
                alert.setTimestamp(readings.getTimestamp());
                alert.setVin(readings.getVin());
                entityManager.persist(alert);
            }

        }

    }


}
