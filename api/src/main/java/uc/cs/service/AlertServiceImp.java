package uc.cs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uc.cs.entity.Alert;
import uc.cs.exception.BadRequestException;
import uc.cs.repository.AlertRepository;

import java.util.List;

@Service
public class AlertServiceImp implements AlertService {

    @Autowired
    AlertRepository arepository;

    @Transactional(readOnly = true)
    public List<Alert> findAll() {
        return arepository.findAll();
    }

    public List<Alert> findByVin(String vin) {

        List<Alert> alerts=arepository.findByVin(vin);

        return alerts;

    }

    public List<Alert> findByPriority(String priority) {

        if(!(priority.equals("HIGH")||priority.equals("MEDIUM")||priority.equals("LOW")))
            throw new BadRequestException("Please pick a value from High, Medium and Low");

        List<Alert> alerts=arepository.findByPriority(priority);

        return alerts;

    }
}
