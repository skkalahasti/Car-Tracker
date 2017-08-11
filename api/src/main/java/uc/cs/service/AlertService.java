package uc.cs.service;

import uc.cs.entity.Alert;
import java.util.List;

public interface AlertService {

    public List<Alert> findAll();

    public List<Alert> findByVin(String vin);

    public List<Alert> findByPriority(String priority);

}
