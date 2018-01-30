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
    public void shouldGetAllTasks() {
        //Given
        Task task = new Task(new Long(1), "Test Driven Development", "TDD");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        when(repository.findAll()).thenReturn(taskList);
        //When
        List<Task> allTasks = dbService.getAllTasks();
        //Then
        assertEquals(taskList, allTasks);
    }

    @Test
    public void shouldGetTaskById() {
        //Given
        Task expectedTask = new Task(new Long(1), "Mockito", "Mock");
        Mockito.when(repository.findById(new Long(1))).thenReturn(Optional.of(expectedTask));
        //When
        Task resTask = dbService.getTaskById(expectedTask.getId());
        //Then
        assertEquals(expectedTask, resTask);

    }

    @Test
    public void shouldSaveTask() {
        //Given
        Task expTask = new Task(new Long(22), "Spring Boot", "Boot");
        List<Task> taskList = new ArrayList<>();
        taskList.add(expTask);
        when(repository.save(expTask)).thenReturn(expTask);
        when(repository.findAll()).thenReturn(taskList);
        //When
        Task finishTask = dbService.saveTask(expTask);
        List<Task> allTasks = dbService.getAllTasks();
        //Then
        assertEquals(expTask, finishTask);

        assertEquals(taskList.size(), allTasks.size());
    }

    @Test
    public void shouldGetTask() {
        //Given
        Task expTask = new Task(new Long(22), "Rest Api", "Api");
        when(repository.findById(expTask.getId())).thenReturn(Optional.ofNullable(expTask));
        //When
        Optional<Task> endTask = dbService.getTask(expTask.getId());
        //Then
        assertEquals(Optional.ofNullable(expTask), endTask);

    }

    @Test
    public void shouldDeleteTask() {
        //Given
        Task expTask = new Task(new Long(22), "Rest Api", "Api");
        repository.deleteById(expTask.getId());
        //When
        //Then
        verify(repository, times(1)).deleteById(expTask.getId());
    }
}
