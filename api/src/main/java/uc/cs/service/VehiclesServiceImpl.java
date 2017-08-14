package uc.cs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uc.cs.exception.ResourceNotFoundException;
import uc.cs.repository.VehicleRepository;
import uc.cs.entity.Vehicles;

import java.util.List;

@Service
public class VehiclesServiceImpl implements VehiclesService {

    @Autowired
    VehicleRepository vrepository;

@Transactional(readOnly = true)
    public List<Vehicles> findAll() {
        return vrepository.findAll();
    }

    @Transactional
    public Vehicles find(String vin) {
        Vehicles vehicles = vrepository.find(vin);
        return vehicles;
}

@Transactional
    public List<Vehicles> createVehicles(List<Vehicles> vehicles) {

        for(Vehicles v:vehicles) {
            System.out.println(find(v.getVin()));
            if (!(find(v.getVin())==null)) {
                vrepository.updateVehicle(v);
            }
            else
                vrepository.create_Vehicle(v);
        }

        return vehicles;
    }

    @Transactional
    public Vehicles delete(String vin) {
    Vehicles vehicles;
    vehicles=vrepository.find(vin);
        if(vehicles==null)
            throw new ResourceNotFoundException("vehicle not found");
        else
        {vrepository.delete(vehicles); return vehicles; }
    }

}
