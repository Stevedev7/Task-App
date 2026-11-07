package com.stevedev7.task.domain.dto;

import com.stevedev7.task.domain.entity.TaskPriority;
import com.stevedev7.task.domain.entity.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record UpdateTaskRequestDto (
    @NotBlank(message = "Title cannot be blank.")
    @Length(max = 255, message = "Title cannot be more than 255 characters length.")
    String title,
    @Length(max = 1000, message = "Description cannot be more than 1000 characters.")
    @Nullable
    String description,
    @Nullable
    @FutureOrPresent(message = "Due date must be in the future.")
    LocalDate dueDate,
    @NotNull(message = "Priority cannot be null.")
    TaskPriority priority,
    @NotNull(message = "Status cannot be null.")
    TaskStatus status
) {
}
