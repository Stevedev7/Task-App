package com.stevedev7.task.controller;

import com.stevedev7.task.domain.CreateTaskRequest;
import com.stevedev7.task.domain.UpdateTaskRequest;
import com.stevedev7.task.domain.dto.CreateTaskRequestDto;
import com.stevedev7.task.domain.dto.TaskDto;
import com.stevedev7.task.domain.dto.UpdateTaskRequestDto;
import com.stevedev7.task.domain.entity.Task;
import com.stevedev7.task.mapper.TaskMapper;
import com.stevedev7.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

  private final TaskService taskService;
  private final TaskMapper taskMapper;


  public TaskController(TaskService taskService, TaskMapper taskMapper) {
    this.taskService = taskService;
    this.taskMapper = taskMapper;
  }

  @PostMapping
  public ResponseEntity<TaskDto> createTask (
      @RequestBody
          @Valid
      CreateTaskRequestDto createTaskRequestDto
  ) {
    CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
    Task task = taskService.createTask(createTaskRequest);
    TaskDto taskDto = taskMapper.toDto(task);

    return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<TaskDto>> listTasks () {
    List<Task> tasks = taskService.listTasks();
    List<TaskDto> taskDtos = tasks.stream().map(taskMapper::toDto).toList();

    return new ResponseEntity<>(taskDtos, HttpStatus.OK);
  }

  @PutMapping(path = "/{taskId}")
  public ResponseEntity<TaskDto> updateTask (
      @PathVariable UUID taskId,
      @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto
  ) {
    UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDto);
    Task task = taskService.updateTask(taskId, updateTaskRequest);
    TaskDto taskDto = taskMapper.toDto(task);
    return new ResponseEntity<>(taskDto, HttpStatus.OK);
  }

  @DeleteMapping(path = "/{taskId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTask (
      @PathVariable UUID taskId
  ) {
    taskService.deleteTask(taskId);
  }
}
