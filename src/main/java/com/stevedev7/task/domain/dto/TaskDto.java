package com.stevedev7.task.domain.dto;

import com.stevedev7.task.domain.entity.TaskPriority;
import com.stevedev7.task.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
    UUID id,
    String title,
    String description,
    LocalDate dueDate,
    TaskPriority priority,
    TaskStatus status
) {
}
