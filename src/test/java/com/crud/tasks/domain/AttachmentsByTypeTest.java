package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AttachmentsByTypeTest {
    @Test
    public void testAttachmentByType() {
        Trello trello = new Trello(1, 1);
        AttachmentsByType attachmentsByType = new AttachmentsByType(trello);
        assertEquals(trello, attachmentsByType.getTrello());
    }
}
