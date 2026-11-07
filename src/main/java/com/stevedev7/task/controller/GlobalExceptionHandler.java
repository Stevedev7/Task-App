package com.stevedev7.task.controller;

import com.stevedev7.task.domain.dto.ErrorDto;
import com.stevedev7.task.exception.TaskNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDto> handleValidationException(MethodArgumentNotValidException ex) {
    String message = ex.getBindingResult().getFieldErrors().stream()
        .findFirst()
        .map(DefaultMessageSourceResolvable::getDefaultMessage)
        .orElse("Validation Failed");

    ErrorDto errorDto = new ErrorDto(message);

    return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(TaskNotFoundException.class)
  public ResponseEntity<ErrorDto> taskNotFound(TaskNotFoundException ex) {
    UUID id = ex.getId();

    ErrorDto errorDto = new ErrorDto(String.format("Task with Id '%s' not found.", id));
    return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);

  }
}

