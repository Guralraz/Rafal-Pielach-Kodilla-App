package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.DBService;
import com.crud.tasks.service.TrelloService;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperTestSuite {
    private TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    void testMapToBoards() {
        //Given
        List<TrelloBoardDTO> trelloBoardDTOList = new ArrayList<>();
        trelloBoardDTOList.add(new TrelloBoardDTO("test1", "1", new ArrayList<>()));
        trelloBoardDTOList.add(new TrelloBoardDTO("test2", "2", new ArrayList<>()));
        trelloBoardDTOList.add(new TrelloBoardDTO("test3", "3", new ArrayList<>()));

        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDTOList);

        //Then
        assertEquals(trelloBoardDTOList.get(0).getId(), trelloBoardList.get(0).getId());
        assertEquals(trelloBoardDTOList.get(1).getId(), trelloBoardList.get(1).getId());
        assertEquals(trelloBoardDTOList.get(2).getId(), trelloBoardList.get(2).getId());
        assertEquals(trelloBoardDTOList.get(0).getName(), trelloBoardList.get(0).getName());
        assertEquals(trelloBoardDTOList.get(1).getName(), trelloBoardList.get(1).getName());
        assertEquals(trelloBoardDTOList.get(2).getName(), trelloBoardList.get(2).getName());
        assertTrue(trelloBoardList.get(0).getLists().isEmpty());
        assertTrue(trelloBoardList.get(1).getLists().isEmpty());
        assertTrue(trelloBoardList.get(2).getLists().isEmpty());
    }

    @Test
    void testMapToBoardsDTO() {
        //Given
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(new TrelloBoard("1", "test1", new ArrayList<>()));
        trelloBoardList.add(new TrelloBoard("2", "test2", new ArrayList<>()));
        trelloBoardList.add(new TrelloBoard("3", "test3", new ArrayList<>()));

        //When
        List<TrelloBoardDTO> trelloBoardDTOList = trelloMapper.mapToBoardsDTO(trelloBoardList);

        //Then
        assertEquals(trelloBoardList.get(0).getId(), trelloBoardDTOList.get(0).getId());
        assertEquals(trelloBoardList.get(1).getId(), trelloBoardDTOList.get(1).getId());
        assertEquals(trelloBoardList.get(2).getId(), trelloBoardDTOList.get(2).getId());
        assertEquals(trelloBoardList.get(0).getName(), trelloBoardDTOList.get(0).getName());
        assertEquals(trelloBoardList.get(1).getName(), trelloBoardDTOList.get(1).getName());
        assertEquals(trelloBoardList.get(2).getName(), trelloBoardDTOList.get(2).getName());
        assertTrue(trelloBoardDTOList.get(0).getLists().isEmpty());
        assertTrue(trelloBoardDTOList.get(1).getLists().isEmpty());
        assertTrue(trelloBoardDTOList.get(2).getLists().isEmpty());
    }

    @Test
    void testMapToList() {
        //Given
        List<TrelloListDTO> trelloListDTO = new ArrayList<>();
        trelloListDTO.add(new TrelloListDTO("1", "test1", true));
        trelloListDTO.add(new TrelloListDTO("2", "test2", true));
        trelloListDTO.add(new TrelloListDTO("3", "test3", true));

        //When
        List<TrelloList> trelloListList = trelloMapper.mapToList(trelloListDTO);

        //Then
        assertEquals(trelloListDTO.get(0).getId(), trelloListList.get(0).getId());
        assertEquals(trelloListDTO.get(1).getId(), trelloListList.get(1).getId());
        assertEquals(trelloListDTO.get(2).getId(), trelloListList.get(2).getId());
        assertEquals(trelloListDTO.get(0).getName(), trelloListList.get(0).getName());
        assertEquals(trelloListDTO.get(1).getName(), trelloListList.get(1).getName());
        assertEquals(trelloListDTO.get(2).getName(), trelloListList.get(2).getName());
        assertTrue(trelloListList.get(0).isClosed());
        assertTrue(trelloListList.get(1).isClosed());
        assertTrue(trelloListList.get(2).isClosed());
    }

    @Test
    void testMapToListDTO() {
        //Given
        List<TrelloList> trelloListList = new ArrayList<>();
        trelloListList.add(new TrelloList("1", "test1", true));
        trelloListList.add(new TrelloList("2", "test2", true));
        trelloListList.add(new TrelloList("3", "test3", true));

        //When
        List<TrelloListDTO> trelloListDTOList = trelloMapper.mapToListDTO(trelloListList);

        //Then
        assertEquals(trelloListList.get(0).getId(), trelloListDTOList.get(0).getId());
        assertEquals(trelloListList.get(1).getId(), trelloListDTOList.get(1).getId());
        assertEquals(trelloListList.get(2).getId(), trelloListDTOList.get(2).getId());
        assertEquals(trelloListList.get(0).getName(), trelloListDTOList.get(0).getName());
        assertEquals(trelloListList.get(1).getName(), trelloListDTOList.get(1).getName());
        assertEquals(trelloListList.get(2).getName(), trelloListDTOList.get(2).getName());
        assertTrue(trelloListDTOList.get(0).isClosed());
        assertTrue(trelloListDTOList.get(1).isClosed());
        assertTrue(trelloListDTOList.get(2).isClosed());
    }

    @Test
    void testMapToCardDTO() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test", "test", "test", "test");
        //When
        TrelloCardDTO trelloCardDTO = trelloMapper.mapToCardDTO(trelloCard);

        //Then
        assertEquals(trelloCard.getName(), trelloCardDTO.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDTO.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDTO.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDTO.getListId());
    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDTO trelloCardDTO = new TrelloCardDTO("test", "test", "test", "test");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDTO);

        //Then
        assertEquals(trelloCardDTO.getName(), trelloCard.getName());
        assertEquals(trelloCardDTO.getDescription(), trelloCard.getDescription());
        assertEquals(trelloCardDTO.getPos(), trelloCard.getPos());
        assertEquals(trelloCardDTO.getListId(), trelloCard.getListId());
    }
}