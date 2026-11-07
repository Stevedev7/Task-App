package com.stevedev7.task.service.impl;

import com.stevedev7.task.domain.CreateTaskRequest;
import com.stevedev7.task.domain.UpdateTaskRequest;
import com.stevedev7.task.domain.entity.Task;
import com.stevedev7.task.domain.entity.TaskStatus;
import com.stevedev7.task.exception.TaskNotFoundException;
import com.stevedev7.task.repository.TaskRepository;
import com.stevedev7.task.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;

  public TaskServiceImpl(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }
  @Override
  public Task createTask(CreateTaskRequest request) {
    Instant now = Instant.now();

    Task newTask = new Task(
        null,
        request.title(),
        TaskStatus.OPEN,
        request.dueDate(),
        request.description(),
        request.priority(),
        now,
        now
    );

    return taskRepository.save(newTask);
  }

  @Override
  public List<Task> listTasks() {

    return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
  }

  @Override
  public Task updateTask(UUID taskId, UpdateTaskRequest request) {
    Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
    task.setTitle(request.title());
    task.setDescription(request.description());
    task.setDueDate(request.dueDate());
    task.setStatus(request.status());
    task.setPriority(request.priority());
    task.setUpdatedAt(Instant.now());

    return taskRepository.save(task);
  }

  @Override
  public void deleteTask(UUID taskId) {
    taskRepository.deleteById(taskId);
  }
}
