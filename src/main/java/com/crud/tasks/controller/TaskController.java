package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @GetMapping
    public List<TaskDTO> getTasks() {
        return new ArrayList<>();
    }

    @GetMapping
    public TaskDTO getTask(Long taskId) {
        return new TaskDTO(1L, "test title", "test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "")
    public void deleteTask(Long taskId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "")
    public TaskDTO updateTask(TaskDTO taskDto) {
        return new TaskDTO(1L, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void createTask(TaskDTO taskDto) {

    }

}
