package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTest {
    @Autowired
    TrelloMapper trelloMapper;

    @Test
    void mapToBoards() {
        //Given
        List<TrelloBoardDTO> trelloBoardDTOList = new ArrayList<>();
        trelloBoardDTOList.add(new TrelloBoardDTO("test1", "1", null));
        trelloBoardDTOList.add(new TrelloBoardDTO("test2", "2", null));
        trelloBoardDTOList.add(new TrelloBoardDTO("test3", "3", null));

        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDTOList);

        //Then
        assertEquals(trelloBoardDTOList.get(0).getId(), trelloBoardList.get(0).getId());
        assertEquals(trelloBoardDTOList.get(1).getId(), trelloBoardList.get(1).getId());
        assertEquals(trelloBoardDTOList.get(2).getId(), trelloBoardList.get(2).getId());
        assertEquals(trelloBoardDTOList.get(0).getName(), trelloBoardList.get(0).getName());
        assertEquals(trelloBoardDTOList.get(1).getName(), trelloBoardList.get(1).getName());
        assertEquals(trelloBoardDTOList.get(2).getName(), trelloBoardList.get(2).getName());
        assertNull(trelloBoardList.get(0).getLists());
        assertNull(trelloBoardList.get(1).getLists());
        assertNull(trelloBoardList.get(2).getLists());
    }

    @Test
    void mapToBoardsDTO() {
    }

    @Test
    void mapToList() {
    }

    @Test
    void mapToListDTO() {
    }

    @Test
    void mapToCardDTO() {
    }

    @Test
    void mapToCard() {
    }
}