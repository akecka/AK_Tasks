package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TaskMapperTest {

    TaskMapper taskMapper = new TaskMapper();

    @Test
    public void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(new Long(1), "Spring", "Spring Boot");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals("Spring", task.getTitle());
    }

    @Test
    public void mapToTaskDto() {
        //Given
        Task task = new Task(new Long(2), "Hibernate", "framework");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals("framework", taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(new Long(3), "Rest Api", "Api"));
        //When
        List<TaskDto> theTaskList = new ArrayList<>();
        theTaskList.addAll(taskMapper.mapToTaskDtoList(taskList));
        //Then
        assertEquals(1, theTaskList.size());
    }


}
