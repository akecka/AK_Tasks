package com.crud.tasks.service;


import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TrelloServiceTest {

    TrelloService trelloService = new TrelloService();

    TrelloClient trelloClient = new TrelloClient();


    @Test
    public void fetchTrelloBoards(){
        //Given
        List<TrelloBoardDto> trelloBoardList = new ArrayList<>();
        TrelloBoardDto trelloBoardList1 = new TrelloBoardDto("Things to do", "2345", new ArrayList<>());
        trelloBoardList.add(trelloBoardList1);
        //When
        List<TrelloBoardDto> resultBoardList = trelloService.fetchTrelloBoards();
        //Then
        assertEquals(trelloBoardList.size(),resultBoardList.size());
    }

    @Test
    public void createTrelloCard(){
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("PostMan", "Toolchain", "23", "234");
        //When
        //TrelloCard trelloCard1 = trelloService.createTrelloCard(trelloCardDto);
        //Then

    }

}
