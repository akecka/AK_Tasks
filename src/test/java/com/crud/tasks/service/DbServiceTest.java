//package com.crud.tasks.service;
//
//import com.crud.tasks.domain.Task;
//import org.junit.Test;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class DbServiceTest {
//
//    private DbService dbService = new DbService();
//
//
//    @Test
//    public void getAllTasks(){
//        //Given
//        Task task = new Task(new Long (1), "Test Driven Development", "TDD");
//        //When
//        dbService.saveTask(task);
//        List<Task> allTasks = dbService.getAllTasks();
//        //Then
//        assertEquals(1, allTasks.size());
//        dbService.deleteTask(task.getId());
//    }
//
//    @Test
//    public void getTaskById(){
//        //Given
//        Task task = new Task(new Long(22), "Mockito", "Mock");
//        dbService.saveTask(task);
//        //When
//        dbService.saveTask(task);
//        Task tasks = dbService.getTaskById(task.getId());
//
//
//
//    }
//}
