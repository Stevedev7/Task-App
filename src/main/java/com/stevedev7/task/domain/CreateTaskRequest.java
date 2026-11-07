package com.stevedev7.task.domain;

import com.stevedev7.task.domain.entity.TaskPriority;

import java.time.LocalDate;

public record CreateTaskRequest(
    String title,
    String description,
    LocalDate dueDate,
    TaskPriority priority
) {

}
