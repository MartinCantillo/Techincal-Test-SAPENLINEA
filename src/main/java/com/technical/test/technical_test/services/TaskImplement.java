package com.technical.test.technical_test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical.test.technical_test.entity.Task;
import com.technical.test.technical_test.entity.User;
import com.technical.test.technical_test.repositories.TaskRepository;

@Service
public class TaskImplement implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskImplement(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public boolean saveTask(Task task) {
        try {
            taskRepository.save(task);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteTask(Long id) {
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Task> findByOwner(User owner) {
        return taskRepository.findByOwner(owner);
    }
}
