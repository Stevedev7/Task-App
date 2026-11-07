package com.stevedev7.task.domain.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="tasks")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  public Task() {
  }

  public Task(UUID id, String title, TaskStatus status, LocalDate dueDate, String description, TaskPriority priority, Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.title = title;
    this.status = status;
    this.dueDate = dueDate;
    this.description = description;
    this.priority = priority;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }

  public void setPriority(TaskPriority priority) {
    this.priority = priority;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public TaskPriority getPriority() {
    return priority;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description", length = 1000)
  private String description;

  @Column(name = "due_date")
  private LocalDate dueDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private TaskStatus status;

  @Enumerated(EnumType.STRING)
  @Column(name = "priority", nullable = false)
  private TaskPriority priority;

  @Column(name = "created_at", updatable = false, nullable = false)
  private Instant createdAt;

  @Column(name = "updated_at", nullable = false)
  private Instant updatedAt;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Task task = (Task) o;
    return Objects.equals(id, task.id);
  }

  @Override
  public String toString() {
    return "Task{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", dueDate=" + dueDate +
        ", status=" + status +
        ", priority=" + priority +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        '}';
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
