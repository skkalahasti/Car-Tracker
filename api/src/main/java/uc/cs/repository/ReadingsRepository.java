package uc.cs.repository;

import uc.cs.entity.Readings;

import java.util.List;

public interface ReadingsRepository {

    public List<Readings> findAll();

    public List<Readings> findByVinandTime(String vin, String time);

    public List<Readings> findByVin(String vin);

    public Readings createReadings(Readings readings);

}
