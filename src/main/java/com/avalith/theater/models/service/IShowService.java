package com.avalith.theater.models.service;

import com.avalith.theater.models.entity.Show;

import java.util.List;

public interface IShowService {
    public List<Show> findAll();
    public Show findById(Long id);
}
