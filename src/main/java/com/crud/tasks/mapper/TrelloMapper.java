package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class TrelloMapper {
    public List<TrelloBoard> mapToBoards(final List<TrelloBoardDTO> trelloBoardDTO) {
        return trelloBoardDTO.stream()
                .map(trelloBoard ->
                        new TrelloBoard(trelloBoard.getId(), trelloBoard.getName(),
                                mapToList(trelloBoard.getLists())))
                .collect(toList());
    }

    public List<TrelloBoardDTO> mapToBoardsDTO(final List<TrelloBoard> trelloBoards) {
        return trelloBoards.stream()
                .map(trelloBoard ->
                        new TrelloBoardDTO(trelloBoard.getId(),
                                trelloBoard.getName(), mapToListDTO(trelloBoard.getLists())))
                .collect(toList());
    }

    public List<TrelloList> mapToList(final List<TrelloListDTO> trelloListDTO) {
        return trelloListDTO.stream()
                .map(trelloList -> new TrelloList(trelloList.getId(),
                        trelloList.getName(), trelloList.isClosed()))
                .collect(toList());
    }

    public List<TrelloListDTO> mapToListDTO(final List<TrelloList> trelloLists) {
        return trelloLists.stream()
                .map(trelloList -> new TrelloListDTO(trelloList.getId(),
                        trelloList.getName(), trelloList.isClosed()))
                .collect(toList());
    }

    public TrelloCardDTO mapToCardDTO(final TrelloCard trelloCard) {
        return new TrelloCardDTO(trelloCard.getName(), trelloCard.getDescription(),
                trelloCard.getPos(), trelloCard.getListId());
    }
    public TrelloCard mapToCard(final TrelloCardDTO trelloCardDTO) {
        return new TrelloCard(trelloCardDTO.getName(), trelloCardDTO.getDescription(),
                trelloCardDTO.getPos(), trelloCardDTO.getListId());
    }
}
