package uc.cs.repository;

import uc.cs.entity.Readings;

import java.util.List;

public interface ReadingsRepository {

    public List<Readings> findAll();

    public Readings createReadings(Readings readings);

}
