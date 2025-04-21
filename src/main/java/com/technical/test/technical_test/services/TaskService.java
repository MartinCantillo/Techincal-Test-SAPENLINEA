package com.technical.test.technical_test.services;

import java.util.List;
import java.util.Optional;

import com.technical.test.technical_test.entity.Task;

public interface TaskService {

     List<Task> findAll();
    Optional<Task> findById(Long id);
    boolean saveTask(Task user );
    boolean deleteTask(Long id);

}
