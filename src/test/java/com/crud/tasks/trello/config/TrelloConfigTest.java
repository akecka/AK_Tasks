package com.crud.tasks.trello.config;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TrelloConfigTest {

    @Test
    public void testTrelloConfig() {
        //Given
        TrelloConfig trelloConfig = new TrelloConfig();
        trelloConfig.getTrelloApiEndPoint();
        trelloConfig.getTrelloAppKey();
        trelloConfig.getTrelloToken();
        trelloConfig.getTrelloUsername();
        //Then
        assertNotNull(trelloConfig.toString());
    }
}
