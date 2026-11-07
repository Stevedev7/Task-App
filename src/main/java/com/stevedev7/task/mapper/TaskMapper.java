package com.stevedev7.task.mapper;

import com.stevedev7.task.domain.CreateTaskRequest;
import com.stevedev7.task.domain.UpdateTaskRequest;
import com.stevedev7.task.domain.dto.CreateTaskRequestDto;
import com.stevedev7.task.domain.dto.TaskDto;
import com.stevedev7.task.domain.dto.UpdateTaskRequestDto;
import com.stevedev7.task.domain.entity.Task;

public interface TaskMapper {
  CreateTaskRequest fromDto(CreateTaskRequestDto dto);
  UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);
  TaskDto toDto(Task task);
}
