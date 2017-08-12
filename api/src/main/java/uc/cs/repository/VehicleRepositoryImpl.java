package uc.cs.repository;

import org.springframework.stereotype.Repository;
import uc.cs.entity.Vehicles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Vehicles> findAll() {
        TypedQuery<Vehicles> query=entityManager.createNamedQuery("Vehicles.findAll",Vehicles.class);

        return query.getResultList();
    }

    public Vehicles updateVehicle(Vehicles vehicles) {
        return entityManager.merge(vehicles);
    }

    public Vehicles create_Vehicle(Vehicles vehicles) {
        entityManager.persist(vehicles);
        return vehicles;

    }

    public Vehicles find(String Vin) {

        TypedQuery<Vehicles> query = entityManager.createNamedQuery("Vehicles.findByvin",Vehicles.class);

        query.setParameter("paramvin", Vin);
        List<Vehicles> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }

    }

    public Vehicles delete(String Vin) {

        TypedQuery<Vehicles> query = entityManager.createNamedQuery("Vehicles.findByvin",Vehicles.class);
        query.setParameter("paramvin", Vin);
        List<Vehicles> resultList = query.getResultList();
        entityManager.remove(resultList.get(0));
        return resultList.get(0);
    }
}
