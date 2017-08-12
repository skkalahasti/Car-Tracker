package uc.cs.repository;

import uc.cs.entity.Vehicles;

import java.util.List;

public interface VehicleRepository {

    public List<Vehicles> findAll();

    public Vehicles updateVehicle(Vehicles vehicles);

    public Vehicles create_Vehicle(Vehicles vehicles);

    public Vehicles find(String Vin);

    public Vehicles delete(String Vin);
}
