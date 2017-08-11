package uc.cs.repository;

import uc.cs.entity.Alert;
import uc.cs.entity.Readings;

import java.util.List;

public interface AlertRepository {

    public List<Alert> findAll();

    public List<Alert> findByPriority(String priority);

    public List<Alert> findByVin(String vin);

    public void checkForAlerts(Readings readings);
}
