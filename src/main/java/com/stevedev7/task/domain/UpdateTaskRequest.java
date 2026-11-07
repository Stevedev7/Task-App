package com.stevedev7.task.domain;

import com.stevedev7.task.domain.entity.TaskPriority;
import com.stevedev7.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest (
    String title,
    String description,
    LocalDate dueDate,
    TaskPriority priority,
    TaskStatus status
) {
}
