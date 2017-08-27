package uc.cs.service;

import uc.cs.entity.Readings;

import java.util.List;

public interface ReadingsService {

    List<Readings> findAll();

    List<Readings> findByVinandTime(String vin, String time);

    List<Readings> findByVin(String vin);

    Readings createReadings(Readings readings);

}
