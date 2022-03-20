package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDTO;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final DBService service;
    private final TaskMapper taskMapper;

    @GetMapping
    public List<TaskDTO> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return taskMapper.mapToTaskDTOList(tasks);
    }

    @GetMapping(value = "{taskId}")
    public TaskDTO getTask(@PathVariable Long taskId) {
        return taskMapper.mapToTaskDTO(service.getTaskById(taskId).get());
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
