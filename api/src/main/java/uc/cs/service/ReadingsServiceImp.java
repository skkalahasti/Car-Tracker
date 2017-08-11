package uc.cs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uc.cs.entity.Readings;
import uc.cs.repository.ReadingsRepository;

import java.util.*;

@Service
public class ReadingsServiceImp implements ReadingsService {

    @Autowired
    ReadingsRepository rrepository;

    @Transactional(readOnly = true)
    public List<Readings> findAll() {
        return rrepository.findAll();
    }

    @Transactional
    public Readings createReadings(Readings readings) {

        return rrepository.createReadings(readings);
    }
}
