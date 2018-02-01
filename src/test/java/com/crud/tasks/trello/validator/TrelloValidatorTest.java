package com.crud.tasks.trello.validator;


import com.crud.tasks.domain.TrelloBoard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TrelloValidatorTest {

    TrelloValidator trelloValidator = new TrelloValidator();

    @Test
    public void shouldValidateBoard() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        TrelloBoard trelloBoard = new TrelloBoard("1", "Hibernate", new ArrayList<>());
        trelloBoards.add(trelloBoard);
        //When
        List<TrelloBoard> resBoards = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        assertEquals(trelloBoards, resBoards);
    }

    @Test
    public void shouldNotValidateBoard() {
        //Given
        List<TrelloBoard> listTrelloBoards = new ArrayList<>();
        List<TrelloBoard> emptyList = new ArrayList<>();
        TrelloBoard trelloBoard = new TrelloBoard("1", "test", new ArrayList<>());
        listTrelloBoards.add(trelloBoard);
        //When
        List<TrelloBoard> resBoards = trelloValidator.validateTrelloBoards(listTrelloBoards);
        //Then
        assertEquals(emptyList, resBoards);
    }

}
