package com.crud.tasks.trello.client;

import com.crud.tasks.config.TrelloConfig;
import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloClientTest {

    @InjectMocks
    private TrelloClient trelloClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TrelloConfig trelloConfig;

    @Test
    public void shouldFetchTrelloBoards() throws URISyntaxException {
        //Given
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
        when(trelloConfig.getTrelloUsername()).thenReturn("test");

        TrelloBoardDTO[] trelloBoards = new TrelloBoardDTO[1];
        trelloBoards[0] = new TrelloBoardDTO("Kodilla", "test_id", new ArrayList<>());

        URI uri = new URI("http://test.com/members/test/boards?key=test&token=test&fields=name,id&lists=all");

        when(restTemplate.getForObject(uri, TrelloBoardDTO[].class)).thenReturn(trelloBoards);

        //When
        List<TrelloBoardDTO> fetchedTrelloBoards = trelloClient.getTrelloBoards();

        // Then
        assertEquals(1, fetchedTrelloBoards.size());
        assertEquals("test_id", fetchedTrelloBoards.get(0).getId());
        assertEquals("Kodilla", fetchedTrelloBoards.get(0).getName());
        assertEquals(new ArrayList<>(), fetchedTrelloBoards.get(0).getLists());
    }

    @Test
    public void shouldCreateCard() throws URISyntaxException {
        // Given
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");

        TrelloCardDTO trelloCardDTO = new TrelloCardDTO(
                "Test task",
                "Test Description",
                "top",
                "test_id"
        );

        URI url = new URI("http://test.com/cards?key=test&token=test&name=Test%20task&desc=Test%20Description&pos=top&idList=test_id");

        CreatedTrelloCardDTO createdTrelloCard = new CreatedTrelloCardDTO(
                "1",
                "Test task",
                "http://test.com",
                new Badges(0, new AttachmentsByType(new Trello(1, 1)))
        );

        when(restTemplate.postForObject(url, null, CreatedTrelloCardDTO.class)).thenReturn(createdTrelloCard);

        // When
        CreatedTrelloCardDTO newCard = trelloClient.createNewCard(trelloCardDTO);

        // Then
        assertEquals("1", newCard.getId());
        assertEquals("Test task", newCard.getName());
        assertEquals("http://test.com", newCard.getShortUrl());
    }

    @Test
    public void shouldReturnEmptyList() throws URISyntaxException {
        //Given
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
        when(trelloConfig.getTrelloUsername()).thenReturn("test");

        TrelloBoardDTO[] trelloBoards = new TrelloBoardDTO[0];

        URI url = new URI("http://test.com/members/test/boards?key=test&token=test&fields=name,id&lists=all");

        when(restTemplate.getForObject(url, TrelloBoardDTO[].class)).thenReturn(trelloBoards);

        //When
        List<TrelloBoardDTO> fetchedTrelloBoards = trelloClient.getTrelloBoards();

        // Then
        assertEquals(0, fetchedTrelloBoards.size());
    }

}