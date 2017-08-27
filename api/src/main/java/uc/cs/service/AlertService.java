package uc.cs.service;

import uc.cs.entity.Alert;
import uc.cs.entity.AlertCount;

import java.util.List;

public interface AlertService {

    public List<Alert> findAll();

    public List<Object> findvincount();

    public List<AlertCount> findvincount(String time);

    public List<Alert> findByVin(String vin);

    public List<Alert> findByVin(String vin, String time);

    public List<Alert> findByPriority(String priority);

    public List<Alert> findByPriorityandtime(String priority, String time);

}
