package uc.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uc.cs.entity.Vehicles;
import uc.cs.service.VehiclesService;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
@RequestMapping(value = "/vehicles")
public class VehiclesController {

    @Autowired
    VehiclesService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicles> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public Vehicles findOne(@PathVariable("vin") String vin1) {
        return service.find(vin1);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicles> create(@RequestBody List<Vehicles> vehicles) {
        return service.createVehicles(vehicles);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public Vehicles delete(@PathVariable("vin") String vin){ return service.delete(vin); }
}