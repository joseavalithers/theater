package com.avalith.theater.models.dao;

import com.avalith.theater.models.entity.Show;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShowDao extends CrudRepository<Show, Long> {
    public List<Show> findByName(String name);
}
