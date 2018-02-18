package com.crud.tasks.service;


import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("preview_message", "Creation of Trello Card");
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://akecka.github.io/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("name", "Alexander");
        context.setVariable("company_name", adminConfig.getCompanyName());
        context.setVariable("company_mail", adminConfig.getCompanyMail());
        context.setVariable("company_phone", adminConfig.getCompanyPhone());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("points_naming", "Application functionality:");
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);

    }

    public String buildScheduledEmail(String message) {

        List<String> rules = new ArrayList<>();
        rules.add("Do the worst first");
        rules.add("Putting accountability to work");
        rules.add("Do not work on a task more than once");

        Context context = new Context();
        context.setVariable("preview_message", "Number of active tasks");
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://akecka.github.io/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("name", "Alexander");
        context.setVariable("company_name", adminConfig.getCompanyName());
        context.setVariable("company_mail", adminConfig.getCompanyMail());
        context.setVariable("company_phone", adminConfig.getCompanyPhone());
        context.setVariable("show_button", true);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("points_naming", "Rules:");
        context.setVariable("application_functionality", rules);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }
}



