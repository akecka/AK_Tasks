package com.crud.tasks.trello.validator;


import com.crud.tasks.domain.TrelloBoard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloValidatorTest {

    TrelloValidator trelloValidator = new TrelloValidator();

    @Test
    public void shouldValidateBoard() {
        //given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        TrelloBoard trelloBoard = new TrelloBoard("1", "Hibernate", new ArrayList<>());
        //when
        trelloBoards.add(trelloBoard);
        //then
        trelloValidator.validateTrelloBoards(trelloBoards);
    }

}
