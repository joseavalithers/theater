package com.avalith.theater.models.dao;

import com.avalith.theater.models.entity.Show;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface ShowDao extends CrudRepository<Show, Long> {
    public List<Show> findByName(String name);
    public List<Show> findByTime(Timestamp timestamp);
}
