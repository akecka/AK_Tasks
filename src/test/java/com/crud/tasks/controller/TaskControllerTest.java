package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService service;

    @MockBean
    private TaskMapper taskMapper;

    @Test
    public void shouldGetTasks() throws Exception {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(new Long(1), "SQL", "databases"));
        List<TaskDto> taskDtos = new ArrayList<>();
        taskDtos.add(new TaskDto(new Long(2), "MySQL", "Database"));
        when(taskMapper.mapToTaskDtoList(tasks)).thenReturn(taskDtos);
        //When & Then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is("1")))
                .andExpect(jsonPath("$[0].title", is("SQL")))
                .andExpect(jsonPath("$[0].content", is("databases")))
                .andExpect(jsonPath("$[0].lists", hasSize(1)))
                .andExpect(jsonPath("$[0].lists[0].id", is("2")))
                .andExpect(jsonPath("$[0].lists[0].title", is("MySQL")))
                .andExpect(jsonPath("$[0].lists[0].content", is("Database")));

    }

    @Test
    public void shouldGetTask() throws Exception {
        //Given
        Task taskId = new Task(new Long(1), "SQL", "databases");
        TaskDto taskDto = new TaskDto(new Long(1), "MySQL", "Database");
        when(taskMapper.mapToTaskDto(taskId)).thenReturn(taskDto);
        //When & Then
        try {
            mockMvc.perform(get("/v1/task/getTask?taskId=1").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(0)));
        } catch (TaskNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldDeleteTask() throws Exception {
        //Given
        Task task1 = new Task(new Long(1), "SQL", "databases");


    }

    @Test
    public void shouldUpdateTask() throws Exception {
    }

    @Test
    public void shouldCreateTask() throws Exception {
    }

}
