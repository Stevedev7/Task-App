package com.stevedev7.task.service;

import com.stevedev7.task.domain.CreateTaskRequest;
import com.stevedev7.task.domain.UpdateTaskRequest;
import com.stevedev7.task.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
  Task createTask (CreateTaskRequest request);
  List<Task> listTasks ();
  Task updateTask(UUID taskId, UpdateTaskRequest request);
  void deleteTask(UUID taskId);
}
