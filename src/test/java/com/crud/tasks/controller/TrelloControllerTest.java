package com.crud.tasks.controller;


import com.crud.tasks.domain.TrelloBoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TrelloControllerTest {

    @InjectMocks
    TrelloController trelloController;


    @Test
    public void getTrelloBoards() {
        //Given
        List<TrelloBoardDto> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoardDto("TrelloTask", "234", new ArrayList<>()));
        //When
        //Then
        assertNotNull(trelloBoard);
    }
}
