package uc.cs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uc.cs.entity.Readings;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public Readings createReadings(Readings readings) {

        entityManager.persist(readings.getTires());
        entityManager.persist(readings);

        //checking for alerts

        arepository.checkForAlerts(readings);
        return readings;
    }

}
