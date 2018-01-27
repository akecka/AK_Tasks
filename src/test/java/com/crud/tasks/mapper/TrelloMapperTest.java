package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {

    TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void mapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoardDto("22234", "Deployment", new ArrayList<>()));
        trelloBoard.add(new TrelloBoardDto("52341", "HTML", new ArrayList<>()));
        trelloBoard.add(new TrelloBoardDto("65784", "Create domain objects", new ArrayList<>()));
        //When
        List<TrelloBoard> theTrelloBoard = new ArrayList<>();
        theTrelloBoard.addAll(trelloMapper.mapToBoards(trelloBoard));
        //Then
        assertEquals(3, theTrelloBoard.size());
    }

    @Test
    public void mapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("33445", "Rest Api 3", new ArrayList<>()));
        trelloBoard.add(new TrelloBoard("65412", "Rest Api 2", new ArrayList<>()));
        trelloBoard.add(new TrelloBoard("35412", "Create architecture api", new ArrayList<>()));
        //When
        List<TrelloBoardDto> theTrelloBoard = new ArrayList<>();
        theTrelloBoard.addAll(trelloMapper.mapToBoardsDto(trelloBoard));
        //Then
        assertEquals(3, theTrelloBoard.size());
    }

    @Test
    public void mapToList() {
        //Given
        List<TrelloListDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListDto("22334", "Design patterns", true));
        trelloLists.add(new TrelloListDto("55443", "Create application controller", true));
        //When
        List<TrelloList> theTrelloList = trelloMapper.mapToList(trelloLists);
        //Then
        assertEquals(trelloLists.get(0).getId(), theTrelloList.get(0).getId());
        assertEquals(trelloLists.get(1).getId(), theTrelloList.get(1).getId());
    }

    @Test
    public void mapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("33333", "Things I am working on", false));
        trelloLists.add(new TrelloList("22333", "Things which I've done", false));
        //When
        List<TrelloListDto> theTrelloLists = trelloMapper.mapToListDto(trelloLists);
        //Then
        assertEquals(theTrelloLists.get(0).getName(), theTrelloLists.get(0).getName());
        assertEquals(theTrelloLists.get(1).getName(), theTrelloLists.get(1).getName());
    }

    @Test
    public void mapToCardDto() {
        //Given
        TrelloCard trelloCard1 = new TrelloCard("Array List", "Useful mechanism", "222", "23");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard1);
        //Then
        assertEquals("Array List", trelloCardDto.getName());
        assertEquals("Useful mechanism", trelloCardDto.getDescription());
        assertEquals("222", trelloCardDto.getPos());
        assertEquals("23", trelloCardDto.getListId());

    }

    @Test
    public void mapToCard() {
        //Given
        TrelloCardDto trelloCardDto1 = new TrelloCardDto("Mockito", "Useful mechanism", "334", "55");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto1);
        //Then
        assertEquals("Mockito", trelloCard.getName());

    }

}
