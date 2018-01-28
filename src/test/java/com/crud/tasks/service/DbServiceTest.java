package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {

    @InjectMocks
    private DbService dbService; //= new DbService();


    @Test
    public void getAllTasks(){
        //Given
        Task task = new Task(new Long (1), "Test Driven Development", "TDD");
        dbService.saveTask(task);
        //When
        List<Task> allTasks = dbService.getAllTasks();
        //Then
        assertNotNull(allTasks);
        dbService.deleteTask(task.getId());
    }

    @Test
    public void getTaskById(){
        //Given
        Task expectedTask = new Task(new Long(22), "Mockito", "Mock");
        dbService.saveTask(expectedTask);
        //When
        Task resTask = dbService.getTaskById(expectedTask.getId());
        //Then
        assertEquals(expectedTask, resTask);
    }
}
