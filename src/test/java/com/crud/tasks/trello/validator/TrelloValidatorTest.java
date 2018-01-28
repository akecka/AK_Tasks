package com.crud.tasks.trello.validator;


import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloValidatorTest {

    TrelloValidator trelloValidator = new TrelloValidator();

    @Test
    public void validateCard(){
        //Given
        TrelloCard trelloCard = new TrelloCard("work", "work to do", "23", "21");
        //When

        //Then
        trelloValidator.validateCard(trelloCard);

    }

    @Test
    public void validateBoard(){
        //given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        TrelloBoard trelloBoard = new TrelloBoard("1", "blabla", new ArrayList<>());
        //when
        trelloBoards.add(trelloBoard);
        //then
        trelloValidator.validateTrelloBoards(trelloBoards);
    }

}
