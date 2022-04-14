package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDTO;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/trello")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("boards")
    public void getTrelloBoards() {

        List<TrelloBoardDTO> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.stream()
                .filter(trelloBoardDTO -> trelloBoardDTO.getId() != null)
                .filter(trelloBoardDTO -> trelloBoardDTO.getName().contains("Kodilla"))
                .forEach(trelloBoardDTO -> {
            System.out.println(trelloBoardDTO.getId() + " " + trelloBoardDTO.getName());
        });
    }
}