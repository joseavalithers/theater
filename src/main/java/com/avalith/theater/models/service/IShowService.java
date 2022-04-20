package com.avalith.theater.models.service;

import com.avalith.theater.models.entity.Show;

import java.sql.Timestamp;
import java.util.List;

public interface IShowService {
    public List<Show> findAll();
    public Show findById(Long id);
    public Show saveShow(Show show);
    public List<Show> findByName(String name);

}
/*
public interface UserService {
    User saverUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
}
 */
