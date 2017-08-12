package uc.cs.service;

import uc.cs.entity.Vehicles;

import java.util.List;

public interface VehiclesService {
    List<Vehicles> findAll();

    Vehicles find(String vin);

    List<Vehicles> createVehicles(List<Vehicles> vehicles);

    Vehicles delete(String vin);

}