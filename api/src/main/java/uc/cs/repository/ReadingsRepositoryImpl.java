package uc.cs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uc.cs.entity.Readings;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReadingsRepositoryImpl implements ReadingsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    AlertRepository arepository;


    public List<Readings> findAll() {
        TypedQuery<Readings> query=entityManager.createNamedQuery("Readings.findAll",Readings.class);

        return query.getResultList();

    }

    public List<Readings> findByVinandTime(String vin, String time){

        String query="SELECT * FROM readings r WHERE (r.vin='"+vin+"'AND DATE_ADD(r.timestamp, INTERVAL "+time +" HOUR) >= now())";

        Query quer=entityManager.createNativeQuery(query,Readings.class);

        return (List<Readings>)quer.getResultList();
    }

    public List<Readings> findByVin(String vin) {

        TypedQuery<Readings> query=entityManager.createNamedQuery("Readings.findByVin",Readings.class);

        query.setParameter("paramvin",vin);

        return query.getResultList();

    }

    public Readings createReadings(Readings readings) {

        entityManager.persist(readings.getTires());
        entityManager.persist(readings);

        //checking for alerts

        arepository.checkForAlerts(readings);
        return readings;
    }
}
