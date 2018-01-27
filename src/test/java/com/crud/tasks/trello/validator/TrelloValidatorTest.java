package com.crud.tasks.trello.validator;


import com.crud.tasks.domain.TrelloCard;
import org.junit.Test;

public class TrelloValidatorTest {

    TrelloValidator trelloValidator = new TrelloValidator();

    @Test
    public void validateCard(){
        //Given
        TrelloCard trelloCard = new TrelloCard("work", "work to do", "23", "21");
        trelloCard.getName();
        //When
        //Then

    }


}
