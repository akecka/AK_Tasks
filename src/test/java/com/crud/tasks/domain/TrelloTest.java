package com.crud.tasks.domain;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrelloTest {

    @Test
    public void testTrello() {
        //Given
        Trello trello = new Trello(2, 2);
        Trello trello1 = new Trello(2, 2);
        //Then
        assertEquals(trello, trello1);

    }

}
