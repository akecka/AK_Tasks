package com.crud.tasks.scheduler;


import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.MailCreatorService;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private MailCreatorService mailCreatorService;

    @Scheduled(fixedDelay = 10000)
    public void sendInformationEmail() {
//        simpleEmailService.send(new Mail(
//                adminConfig.getAdminMail(),
//                SUBJECT, createBody()
//                , ""));
        simpleEmailService.send(
                new Mail(adminConfig.getAdminMail(),
                        SUBJECT, mailCreatorService.buildScheduledEmail(createBody()), ""), "schedule");

    }

    public String createBody() {
        long size = taskRepository.count();
        String t;
        if (size == 1) {
            t = "task";
        } else {
            t = "tasks";
        }
        return "Currently you have: " + size + " " + t + " in your database.";

    }

}
