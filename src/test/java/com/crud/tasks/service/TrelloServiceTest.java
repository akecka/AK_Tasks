package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @InjectMocks
    TrelloService trelloService;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;


    @Test
    public void shouldCreateTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("PostMan", "Toolchain", "23", "234");
        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(new CreatedTrelloCardDto("22", "PostMan", "www"));
        //When
        CreatedTrelloCardDto trelloCard1 = trelloService.createTrelloCard(trelloCardDto);
        //Then
        assertEquals(trelloCardDto.getName(), trelloCard1.getName());
    }

    @Test
    public void shouldFetchTrelloBoards() {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "PostMan", new ArrayList<>());
        List<TrelloBoardDto> trelloDtoList = new ArrayList<>();
        trelloDtoList.add(trelloBoardDto);
        when(trelloClient.getTrelloBoards()).thenReturn(trelloDtoList);
        //When
        List<TrelloBoardDto> resultBoardList = trelloService.fetchTrelloBoards();
        //Then
        assertEquals(1, resultBoardList.size());
    }
}
