package com.crud.tasks.service;


import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://akecka.github.io/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        return templateEngine.process("src/main/resources/templates.mail/created-trello-card-mail.html", context);
        //templates.mail/created-trello-card-mail.html
        //C:\Users\Borsuk\Downloads\tasks\tasks\src\main\resources\templates.mail\created-trello-card-mail.html
    }
}



