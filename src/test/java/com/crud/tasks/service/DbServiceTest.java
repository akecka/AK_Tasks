package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository repository;


    @Test
    public void getAllTasks() {
        //Given
        Task task = new Task(new Long(1), "Test Driven Development", "TDD");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        when(dbService.getAllTasks()).thenReturn(taskList);
        //When
        List<Task> allTasks = dbService.getAllTasks();
        //Then
        assertEquals(taskList, allTasks);
    }

    @Test
    public void getTaskById() {
        //Given
        Task expectedTask = new Task(new Long(1), "Mockito", "Mock");
        Mockito.when(Optional.ofNullable(dbService.getTaskById(new Long(1)))).thenReturn(Optional.ofNullable(expectedTask));
        //When
        Task resTask = dbService.getTaskById(expectedTask.getId());
        //Then
        assertEquals(expectedTask, resTask);
    }

    @Test
    public void saveTask() {
        //Given
        Task expTask = new Task(new Long(22), "Spring Boot", "Boot");
        when(dbService.saveTask(expTask)).thenReturn(expTask);
        //When
        Task finishTask = dbService.saveTask(expTask);
        //Then
        assertEquals(expTask, finishTask);
    }

    @Test
    public void getTask() {
        //Given
        Task expTask = new Task(new Long(22), "Rest Api", "Api");
        when(dbService.getTask(expTask.getId())).thenReturn(Optional.ofNullable(expTask));
        //When
        Optional<Task> endTask = dbService.getTask(expTask.getId());
        //Then
        assertEquals(Optional.ofNullable(expTask), endTask);

    }

    @Test
    public void deleteTask() {
        //given
        Task expTask = new Task(new Long(22), "Rest Api", "Api");
        dbService.deleteTask(expTask.getId());
        //when

        //then
        verify(repository, times(1)).deleteById(expTask.getId());
    }
}
