package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mail {

    private String mailTo;
    private String subject;
    private String message;
    private String toCc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mail mail = (Mail) o;

        if (mailTo != null ? !mailTo.equals(mail.mailTo) : mail.mailTo != null) return false;
        if (subject != null ? !subject.equals(mail.subject) : mail.subject != null) return false;
        if (message != null ? !message.equals(mail.message) : mail.message != null) return false;
        return toCc.equals(mail.toCc);
    }

    @Override
    public int hashCode() {
        int result = mailTo != null ? mailTo.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + toCc.hashCode();
        return result;
    }
}
