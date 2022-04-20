package com.avalith.theater.models.service;

import com.avalith.theater.models.dao.ScheduleDao;
import com.avalith.theater.models.dao.ShowDao;
import com.avalith.theater.models.entity.Show;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ShowServiceImpl implements IShowService{
    @Autowired
    private ShowDao showDao;

    private final ScheduleDao scheduleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Show> findAll() {
        return (List<Show>) showDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Show findById(Long id) {
        return null;
    }

    @Override
    public Show saveShow(Show show) {
        return null;
    }

    @Override
    public void addScheduleToShow(String name, Timestamp timestamp) {

    }

    @Override
    public List<Show> findByName(String name) {
        return null;
    }
}
