package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @GetMapping
    public List<TaskDTO> getTasks() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{taskId}")
    public TaskDTO getTask(@PathVariable Long taskId) {
        return new TaskDTO(1L, "test title", "test_content");
    }

    @DeleteMapping
    public void deleteTask(Long taskId) {

    }

    @PutMapping
    public TaskDTO updateTask(TaskDTO taskDto) {
        return new TaskDTO(1L, "Edited test title", "Test content");
    }

    @PostMapping
    public void createTask(TaskDTO taskDto) {

    }

}
