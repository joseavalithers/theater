package com.avalith.theater.models.dao;

import com.avalith.theater.models.entity.Show;
import org.springframework.data.repository.CrudRepository;

public interface ShowDao extends CrudRepository<Show, Long> {

}
