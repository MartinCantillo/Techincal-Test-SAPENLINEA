package com.technical.test.technical_test.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.technical.test.technical_test.entity.Task;
import com.technical.test.technical_test.entity.User;



public interface TaskRepository extends CrudRepository<Task, Long>  {

    List<Task> findByOwner(User owner);
}
