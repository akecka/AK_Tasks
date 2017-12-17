package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;

import java.util.ArrayList;
import java.util.List;

import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/getTasks")
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getTask", params = "id")
    public TaskDto getTask(@RequestParam("id") long id) {
        return new TaskDto(id, "test title", "test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTask")
    public void deleteTask(String taskId) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateTask", params = "id")
    public TaskDto updateTask(@RequestParam("id") long id) {
        return new TaskDto(id, "Edited Title", "Edited Content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createTask")
    public void createTask(TaskDto taskDto) {
    }
    @RequestMapping(method = RequestMethod.GET, value = "/getTaskById", params = "id")
    public Task getTaskById(@RequestParam("id") long id){
        return service.getTaskById(id);

    }
}

