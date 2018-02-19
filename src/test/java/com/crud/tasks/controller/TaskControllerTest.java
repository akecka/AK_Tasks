package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
        taskDtos.add(new TaskDto(new Long(1), "SQL", "databases"));
        when(taskMapper.mapToTaskDtoList(tasks)).thenReturn(taskDtos);
        when(service.getAllTasks()).thenReturn(tasks);
        //When & Then
        mockMvc.perform(get("/tasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("SQL")))
                .andExpect(jsonPath("$[0].content", is("databases")));


    }

    @Test
    public void shouldGetTask() throws Exception {
        //Given
        Task taskId = new Task(new Long(1), "SQL", "databases");
        TaskDto taskDto = new TaskDto(new Long(1), "SQL", "databases");
        when(taskMapper.mapToTaskDto(taskId)).thenReturn(taskDto);
        when(service.getTask(new Long(1))).thenReturn(Optional.ofNullable(taskId));
        //When & Then
        mockMvc.perform(get("/tasks/{taskId}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("SQL")))
                .andExpect(jsonPath("$.content", is("databases")));

    }

    @Test
    public void shouldDeleteTask() throws Exception {
        //Given
        Task task = new Task(new Long(1), "SQL", "databases");
        service.saveTask(task);
        //When & Then
        service.deleteTask(new Long(1));
        mockMvc.perform(delete("/tasks/{taskId}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

    }

    @Test
    public void shouldUpdateTask() throws Exception {
        //Given
        Task task1 = new Task(new Long(1), "SQL", "databases");
        TaskDto taskDto = new TaskDto(new Long(1), "SQL", "databases");
        when(taskMapper.mapToTaskDto(task1)).thenReturn(taskDto);
        when(taskMapper.mapToTask(taskDto)).thenReturn(task1);
        when(service.saveTask(task1)).thenReturn(task1);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        //When & Then
        mockMvc.perform(put("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("SQL")))
                .andExpect(jsonPath("$.content", is("databases")));

    }

    @Test
    public void shouldCreateTask() throws Exception {
        //Given
        Task task1 = new Task(new Long(1), "SQL", "databases");
        TaskDto taskDto = new TaskDto(new Long(1), "SQL", "databases");
        when(taskMapper.mapToTask(taskDto)).thenReturn(task1);
        when(service.saveTask(task1)).thenReturn(task1);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        //When & Then
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

}
