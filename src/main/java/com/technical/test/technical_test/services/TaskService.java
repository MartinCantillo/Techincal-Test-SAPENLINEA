package com.technical.test.technical_test.services;

import java.util.List;
import java.util.Optional;

import com.technical.test.technical_test.entity.Task;
import com.technical.test.technical_test.entity.User;

public interface TaskService {

     List<Task> findAll();
    Optional<Task> findById(Long id);
    boolean saveTask(Task user );
    boolean deleteTask(Long id);
    List<Task> findByOwner(User owner);

}
