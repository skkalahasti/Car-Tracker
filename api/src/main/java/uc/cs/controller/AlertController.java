package uc.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uc.cs.entity.Alert;
import uc.cs.entity.AlertCount;
import uc.cs.service.AlertService;

import java.util.List;


@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping(value = "/alerts")
public class AlertController {

    @Autowired
    AlertService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="/vincount")
    public List<Object> findvincount() {
        return service.findvincount();
    }

    @RequestMapping(method = RequestMethod.GET, value="/vincount/{time}")
    public List<AlertCount> findvincount(@PathVariable("time") String time) {
        return service.findvincount(time);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vin/{vin}")
    public List<Alert> findByVin(@PathVariable("vin") String vin) {
        return service.findByVin(vin);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vin/{vin}/{time}")
    public List<Alert> findByVin(@PathVariable("vin") String vin, @PathVariable("time") String time) {
        return service.findByVin(vin,time);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/priority/{priority}")
    public List<Alert> findByPriority(@PathVariable("priority") String priority) { return service.findByPriority(priority); }

    @RequestMapping(method = RequestMethod.GET, value = "/priority/{priority}/{time}")
    public List<Alert> findByPriorityandtime(@PathVariable("priority") String priority, @PathVariable("time") String time) { return service.findByPriorityandtime(priority,time); }


}
