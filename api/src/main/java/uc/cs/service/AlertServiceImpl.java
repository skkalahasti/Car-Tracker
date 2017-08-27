package uc.cs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uc.cs.entity.Alert;
import uc.cs.entity.AlertCount;
import uc.cs.exception.BadRequestException;
import uc.cs.repository.AlertRepository;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRepository arepository;

    @Transactional(readOnly = true)
    public List<Alert> findAll() {
        return arepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Object> findvincount() {
        return arepository.findvincount();
    }

    @Transactional(readOnly = true)
    public List<AlertCount> findvincount(String time) {
        return arepository.findvincount(time);
    }

    public List<Alert> findByVin(String vin) {

        List<Alert> alerts=arepository.findByVin(vin);

        return alerts;

    }

    public List<Alert> findByVin(String vin, String time) {

        List<Alert> alerts=arepository.findByVin(vin,time);

        return alerts;

    }


    public List<Alert> findByPriority(String priority) {

        if(!(priority.equalsIgnoreCase("HIGH")||priority.equalsIgnoreCase("MEDIUM")||priority.equalsIgnoreCase("LOW")))
            throw new BadRequestException("Please pick a value from High, Medium and Low");

        List<Alert> alerts=arepository.findByPriority(priority);

        return alerts;

    }

    public List<Alert> findByPriorityandtime(String priority, String time) {

        if(!(priority.equalsIgnoreCase("HIGH")||priority.equalsIgnoreCase("MEDIUM")||priority.equalsIgnoreCase("LOW")))
            throw new BadRequestException("Please pick a value from High, Medium and Low");

        List<Alert> alerts=arepository.findByPriorityandtime(priority,time);

        return alerts;

    }
}

