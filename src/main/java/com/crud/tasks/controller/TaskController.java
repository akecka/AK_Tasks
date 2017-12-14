package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @RequestMapping(method = RequestMethod.GET, value = "/getTasks")
    public List<TaskDto> getTasks() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/v1/task/getTask?id=10", params = "id")
    public TaskDto getTask(@RequestParam("id") long id) {
        return new TaskDto(id, "test title", "test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTask")
    public void deleteTask(String taskId) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/v1/task/updateTask?id=10", params = "id")
    public TaskDto updateTask(@RequestParam("id") long id) {
        return new TaskDto(id, "Edited Title", "Edited Content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createTask")
    public void createTask(TaskDto taskDto) {
    }
}
