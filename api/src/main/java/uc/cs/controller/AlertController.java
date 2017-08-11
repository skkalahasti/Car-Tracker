package uc.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uc.cs.entity.Alert;
import uc.cs.service.AlertService;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://mocker.egen.io",maxAge = 3600)
@RequestMapping(value = "/alerts")
public class AlertController {

    @Autowired
    AlertService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vin/{vin}")
    public List<Alert> findByVin(@PathVariable("vin") String vin) {
        return service.findByVin(vin);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/priority/{priority}")
    public List<Alert> findByPriority(@PathVariable("priority") String priority) { return service.findByPriority(priority); }


}
