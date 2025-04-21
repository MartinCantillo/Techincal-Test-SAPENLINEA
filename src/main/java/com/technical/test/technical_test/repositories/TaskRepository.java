package com.technical.test.technical_test.repositories;

import org.springframework.data.repository.CrudRepository;

import com.technical.test.technical_test.entity.Task;



public interface TaskRepository extends CrudRepository<Task, Long>  {

}
