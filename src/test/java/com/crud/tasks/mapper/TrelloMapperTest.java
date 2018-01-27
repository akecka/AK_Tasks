package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TrelloMapperTest {

    TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void mapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        TrelloBoardDto boardDto1 = new TrelloBoardDto("22234", "Deployment", new ArrayList<>());
        TrelloBoardDto boardDto2 = new TrelloBoardDto("52341", "HTML", new ArrayList<>());
        TrelloBoardDto boardDto3 = new TrelloBoardDto("65784", "Create domain objects", new ArrayList<>());
        trelloBoardDtos.add(boardDto1);
        trelloBoardDtos.add(boardDto2);
        trelloBoardDtos.add(boardDto3);
        //When
        List<TrelloBoard> resultList = trelloMapper.mapToBoards(trelloBoardDtos);
        //Then
        assertEquals(trelloBoardDtos.size(), resultList.size());
    }

    @Test
    public void mapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        TrelloBoard board1 = new TrelloBoard("33445", "Rest Api 3", new ArrayList<>());
        TrelloBoard board2 = new TrelloBoard("65412", "Rest Api 2", new ArrayList<>());
        TrelloBoard board3 = new TrelloBoard("35412", "Create architecture api", new ArrayList<>());
        trelloBoard.add(board1);
        trelloBoard.add(board2);
        trelloBoard.add(board3);
        //When
        List<TrelloBoardDto> theTrelloBoard = trelloMapper.mapToBoardsDto(trelloBoard);
        //Then
        assertEquals(trelloBoard.size(), theTrelloBoard.size());
    }

    @Test
    public void mapToList() {
        //Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        TrelloListDto trelloList1 = new TrelloListDto("22334", "Design patterns", true);
        TrelloListDto trelloList2 = new TrelloListDto("55443", "Create application controller", true);
        trelloListsDto.add(trelloList1);
        trelloListsDto.add(trelloList2);
        //When
        List<TrelloList> resultTrelloList = trelloMapper.mapToList(trelloListsDto);
        //Then
        assertEquals(trelloListsDto.size(), resultTrelloList.size());

    }

    @Test
    public void mapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        TrelloList trelloList1 = new TrelloList("33333", "Things I am working on", false);
        TrelloList trelloList2 = new TrelloList("22333", "Things which I've done", false);
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);
        //When
        List<TrelloListDto> resTrelloLists = trelloMapper.mapToListDto(trelloLists);
        //Then
        assertEquals(trelloLists.size(), resTrelloLists.size());

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
