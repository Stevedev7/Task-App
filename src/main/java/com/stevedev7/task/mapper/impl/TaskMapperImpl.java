package com.stevedev7.task.mapper.impl;

import com.stevedev7.task.domain.CreateTaskRequest;
import com.stevedev7.task.domain.UpdateTaskRequest;
import com.stevedev7.task.domain.dto.CreateTaskRequestDto;
import com.stevedev7.task.domain.dto.TaskDto;
import com.stevedev7.task.domain.dto.UpdateTaskRequestDto;
import com.stevedev7.task.domain.entity.Task;
import com.stevedev7.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
  @Override
  public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
    return new CreateTaskRequest(
        dto.title(),
        dto.description(),
        dto.dueDate(),
        dto.priority()
    );
  }

  @Override
  public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {

    return new UpdateTaskRequest(
        dto.title(),
        dto.description(),
        dto.dueDate(),
        dto.priority(),
        dto.status()
    );
  }

  @Override
  public TaskDto toDto(Task task) {
    System.out.println(task.toString());
    return new TaskDto(
        task.getId(),
        task.getTitle(),
        task.getDescription(),
        task.getDueDate(),
        task.getPriority(),
        task.getStatus()
    );
  }
}
