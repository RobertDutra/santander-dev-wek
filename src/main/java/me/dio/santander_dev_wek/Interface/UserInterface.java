package me.dio.santander_dev_wek.Interface;

import me.dio.santander_dev_wek.exceptions.EntityNotFoundException;
import me.dio.santander_dev_wek.model.User;

import java.util.List;

public interface UserInterface {

    User findById(Long id) throws EntityNotFoundException;

    User create(User user) throws EntityNotFoundException;

    User update(Long id, User userUpdate) throws EntityNotFoundException;

    List<User> findAll();

    void delete(Long id) throws EntityNotFoundException;
}
