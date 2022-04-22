package com.avalith.theater.models.service;

import com.avalith.theater.models.dao.ShowDao;
import com.avalith.theater.models.entity.Show;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ShowServiceImpl implements IShowService{
    @Autowired
    private ShowDao showDao;

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
        return showDao.save(show);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Show> findByName(String name) {
        return showDao.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
        showDao.deleteById(id);
    }
}
