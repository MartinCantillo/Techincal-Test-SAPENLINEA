package com.technical.test.technical_test.services;

import java.util.List;
import java.util.Optional;

import com.technical.test.technical_test.entity.User;

public interface  UserService {

    List<User> findAll();
    Optional<User> findById(Long id);
    boolean saveUser(User user );
    boolean deleteUser(Long id);

}
