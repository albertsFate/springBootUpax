package com.examu.upaxrest.service.Impl;


import com.examu.upaxrest.models.Employee;
import com.examu.upaxrest.models.Hour;
import com.examu.upaxrest.repository.HourRepo;
import com.examu.upaxrest.service.HourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HourServiceImplement implements HourService {
    @PersistenceContext
    private EntityManager entityManager;

    private final HourRepo hoursRepo;

    @Override
    public Hour createHours(Hour hour) {
        return hoursRepo.save(hour);
    }

    @Override
    public Integer countHours(Long id, Date start_date, Date end_date) {
        return hoursRepo.countHour(id, start_date, end_date);
    }
}
