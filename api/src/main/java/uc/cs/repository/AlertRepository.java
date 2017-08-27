package uc.cs.repository;

import uc.cs.entity.Alert;
import uc.cs.entity.AlertCount;
import uc.cs.entity.Readings;

import java.util.List;

public interface AlertRepository {

    public List<Alert> findAll();

    public List<Object> findvincount();

    public List<AlertCount> findvincount(String time);

    public List<Alert> findByPriority(String priority);

    public List<Alert> findByVin(String vin);

    public List<Alert> findByVin(String vin,String time);

    public void checkForAlerts(Readings readings);

    public List<Alert> findByPriorityandtime(String priority, String time);

}
