package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask", params = "id")
    public TaskDto getTask(@RequestParam("id") long id){
        return new TaskDto(id, "test title", "test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(String taskId) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "updateTask", params = "id")
    public TaskDto updateTask(@RequestParam("id")long id) {
        return new TaskDto(id, "Edited Title", "Edited Content");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "createTask")
    public void createTask(TaskDto taskDto) {
    }

}
