package com.avalith.theater.models.service;

import com.avalith.theater.models.dao.ShowDao;
import com.avalith.theater.models.entity.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ShowServiceImpl implements IShowService{
    @Autowired
    private ShowDao showDao;

    @Override
    @Transactional(readOnly = true)
    public List<Show> findAll() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Show findById(Long id) {
        return null;
    }
}
