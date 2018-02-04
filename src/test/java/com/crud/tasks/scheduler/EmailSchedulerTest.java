package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTest {
    @InjectMocks
    EmailScheduler emailScheduler;

    @Mock
    private SimpleEmailService simpleEmailService;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private AdminConfig adminConfig;

    @Test
    public void shouldSendInformationEmail() {
        //Given
        when(adminConfig.getAdminMail()).thenReturn("borsukagn@gmail.com");
        when(taskRepository.count()).thenReturn(45L);
        String body = emailScheduler.createBody();
        Mail mail = new Mail("borsukagn@gmail.com", "Tasks: Once a day email", body, "");
        //When
        emailScheduler.sendInformationEmail();
        //Then
        System.out.println(mail.getMailTo());
        System.out.println(mail.getMessage());
        verify(simpleEmailService, times(1)).send(mail);
    }

    @Test
    public void shouldReturnTask(){
        //Given
        when(taskRepository.count()).thenReturn(1L);
        String body = emailScheduler.createBody();
        //When
        String t = " task ";
        //Then
        assertEquals(true, body.contains(t));

    }

    @Test
    public void shouldReturnTasks() {
        //Given
        when(taskRepository.count()).thenReturn(45L);
        String body = emailScheduler.createBody();
        //When
        String t = " tasks ";
        //Then
        assertEquals(true, body.contains(t));

    }

}
