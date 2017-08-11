package uc.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uc.cs.entity.Readings;
import uc.cs.service.ReadingsService;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
@RequestMapping(value = "/readings")
public class ReadingsController {

    @Autowired
    ReadingsService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Readings> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Readings create(@RequestBody Readings readings)
    {
        return service.createReadings(readings);
    }


}