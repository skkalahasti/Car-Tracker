package uc.cs.service;

import uc.cs.entity.Readings;

import java.util.List;

public interface ReadingsService {

    List<Readings> findAll();

    Readings createReadings(Readings readings);

}
