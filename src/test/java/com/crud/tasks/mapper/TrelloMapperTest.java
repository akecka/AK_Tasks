package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TrelloMapperTest {

    TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void shouldMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        TrelloBoardDto boardDto1 = new TrelloBoardDto("22234", "Deployment", new ArrayList<>());
        TrelloBoardDto boardDto2 = new TrelloBoardDto("52341", "HTML", new ArrayList<>());
        TrelloBoardDto boardDto3 = new TrelloBoardDto("65784", "Create domain objects", new ArrayList<>());
        trelloBoardDtos.add(boardDto1);
        trelloBoardDtos.add(boardDto2);
        trelloBoardDtos.add(boardDto3);
        List<TrelloBoard> expectedTrelloBoards = new ArrayList<>();
        TrelloBoard board1 = new TrelloBoard("22234", "Deployment", new ArrayList<>());
        TrelloBoard board2 = new TrelloBoard("52341", "HTML", new ArrayList<>());
        TrelloBoard board3 = new TrelloBoard("65784", "Create domain objects", new ArrayList<>());
        expectedTrelloBoards.add(board1);
        expectedTrelloBoards.add(board2);
        expectedTrelloBoards.add(board3);
        //When
        List<TrelloBoard> resultList = trelloMapper.mapToBoards(trelloBoardDtos);
        //Then
        assertEquals(expectedTrelloBoards, resultList);

    }

    @Test
    public void shouldMapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        TrelloBoard board1 = new TrelloBoard("33445", "Rest Api 3", new ArrayList<>());
        TrelloBoard board2 = new TrelloBoard("65412", "Rest Api 2", new ArrayList<>());
        TrelloBoard board3 = new TrelloBoard("35412", "Create architecture api", new ArrayList<>());
        trelloBoard.add(board1);
        trelloBoard.add(board2);
        trelloBoard.add(board3);
        List<TrelloBoardDto> expectedBoards = new ArrayList<>();
        TrelloBoardDto boardDto1 = new TrelloBoardDto("33445", "Rest Api 3", new ArrayList<>());
        TrelloBoardDto boardDto2 = new TrelloBoardDto("65412", "Rest Api 2", new ArrayList<>());
        TrelloBoardDto boardDto3 = new TrelloBoardDto("35412", "Create architecture api", new ArrayList<>());
        expectedBoards.add(boardDto1);
        expectedBoards.add(boardDto2);
        expectedBoards.add(boardDto3);
        //When
        List<TrelloBoardDto> resultTrelloBoard = trelloMapper.mapToBoardsDto(trelloBoard);
        //Then
        assertEquals(expectedBoards, resultTrelloBoard);
    }

    @Test
    public void shouldMapToList() {
        //Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        TrelloListDto trelloListDto1 = new TrelloListDto("22334", "Design patterns", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("55443", "Create application controller", true);
        trelloListsDto.add(trelloListDto1);
        trelloListsDto.add(trelloListDto2);
        List<TrelloList> expectedList = new ArrayList<>();
        TrelloList trelloList1 = new TrelloList("22334", "Design patterns", true);
        TrelloList trelloList2 = new TrelloList("55443", "Create application controller", true);
        expectedList.add(trelloList1);
        expectedList.add(trelloList2);
        //When
        List<TrelloList> resultTrelloList = trelloMapper.mapToList(trelloListsDto);
        //Then
        assertEquals(expectedList, resultTrelloList);

    }

    @Test
    public void shouldMapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        TrelloList trelloList1 = new TrelloList("33333", "Things I am working on", false);
        TrelloList trelloList2 = new TrelloList("22333", "Things which I've done", false);
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);
        List<TrelloListDto> expectedTrelloLists = new ArrayList<>();
        TrelloListDto trelloListDto1 = new TrelloListDto("33333", "Things I am working on", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("22333", "Things which I've done", false);
        expectedTrelloLists.add(trelloListDto1);
        expectedTrelloLists.add(trelloListDto2);
        //When
        List<TrelloListDto> resTrelloLists = trelloMapper.mapToListDto(trelloLists);
        //Then
        assertEquals(expectedTrelloLists, resTrelloLists);

    }

    @Test
    public void shouldMapToCardDto() {
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
    public void shouldMapToCard() {
        //Given
        TrelloCardDto trelloCardDto1 = new TrelloCardDto("Mockito", "Useful mechanism", "334", "55");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto1);
        //Then
        assertEquals("Mockito", trelloCard.getName());

    }

}
