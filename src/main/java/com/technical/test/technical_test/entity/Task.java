package com.technical.test.technical_test.entity;

import java.time.LocalDateTime;

import com.technical.test.technical_test.enums.TaskStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; 

    private String description; 

    private LocalDateTime dueDate; 

    @Enumerated(EnumType.STRING)
    private TaskStatus status; 

    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name = "user_id")
    private User owner; 

}
