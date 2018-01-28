package com.crud.tasks.service;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @InjectMocks
    TrelloService trelloService;


    @Test
    public void createTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("PostMan", "Toolchain", "23", "234");
        trelloService.createTrelloCard(trelloCardDto);
        //When
        CreatedTrelloCardDto trelloCard1 = trelloService.createTrelloCard(trelloCardDto);
        //Then
        assertEquals(trelloCardDto.getName(), trelloCard1.getName());
    }

    @Test
    public void fetchTrelloBoards() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("blaa", "blaaaa", "1", "1");
        trelloService.createTrelloCard(trelloCardDto);
        //When
        List<TrelloBoardDto> resultBoardList = trelloService.fetchTrelloBoards();
        //Then
        assertEquals(1, resultBoardList.size());
    }
}
