package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BadgesTest {

    @Test
    public void testBadges(){
        //Given
        Trello trello = new Trello(1, 1);
        Badges badges = new Badges(2, new AttachmentsByType(trello));
        //Then
        assertEquals(trello, badges.getAttachmentsByType().getTrello());

    }
}
