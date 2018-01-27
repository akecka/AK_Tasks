package com.crud.tasks.service;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    TrelloService trelloService;

    @Test
    public void createTrelloCard(){
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("PostMan", "Toolchain", "23", "234");
        //When
        CreatedTrelloCardDto trelloCard1 = trelloService.createTrelloCard(trelloCardDto);
        //Then
        assertNotNull(trelloCard1);

    }
    @Test
    public void fetchTrelloBoards(){
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("blaa", "blaaaa", "1", "1");
        trelloService.createTrelloCard(trelloCardDto);
        //When
        List<TrelloBoardDto> resultBoardList = trelloService.fetchTrelloBoards();
        //Then
        assertEquals(1,resultBoardList.size());
    }



}
