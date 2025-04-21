package com.technical.test.technical_test.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.technical.test.technical_test.entity.Task;
import com.technical.test.technical_test.entity.User;
import com.technical.test.technical_test.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;


    
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PreAuthorize("hasRole('User') or hasRole('Admin')")
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId); 
        List<Task> tasks = taskService.findByOwner(user);
        return ResponseEntity.ok(tasks);
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.findById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('User') or hasRole('Admin')")  
    @PostMapping("addtask")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        if (taskService.saveTask(task)) {
            return ResponseEntity.ok("Tarea guardada");
        } else {
            return ResponseEntity.status(500).body("Error al guardar la tarea");
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        if (taskService.deleteTask(id)) {
            return ResponseEntity.ok("Tarea eliminada");
        } else {
            return ResponseEntity.status(500).body("Error al eliminar la tarea");
        }
    }
}

