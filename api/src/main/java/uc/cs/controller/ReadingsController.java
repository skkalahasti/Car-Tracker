package uc.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uc.cs.entity.Readings;
import uc.cs.service.ReadingsService;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping(value = "/readings")
public class ReadingsController {

    @Autowired
    ReadingsService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Readings> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public List<Readings> findByVin(@PathVariable String vin) {
        return service.findByVin(vin);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}/{time}")
    public List<Readings> findByVinandTime(@PathVariable String vin, @PathVariable String time) {
        return service.findByVinandTime(vin, time);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Readings create(@RequestBody Readings readings)
    {
        return service.createReadings(readings);
    }


}