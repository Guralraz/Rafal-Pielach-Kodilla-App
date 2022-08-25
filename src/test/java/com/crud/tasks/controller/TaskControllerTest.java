package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDTO;
import com.crud.tasks.domain.TrelloListDTO;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DBService;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(TaskController.class)
class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TaskMapper taskMapper;
    @MockBean
    private DBService service;

    @Test
    void getTasks() {
    }

    @Test
    void getTask() {
    }

    @Test
    void deleteTask() {
    }

    @Test
    void updateTask() {
    }

    @Test
    void createTask() {
    }
}