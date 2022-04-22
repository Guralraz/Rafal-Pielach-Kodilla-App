package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.TrelloBoardDTO;
import com.crud.tasks.domain.TrelloCardDTO;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class TrelloService {

    private static final String SUBJECT = "Tasks: New Trello card";

    private final TrelloClient trelloClient;
    private final SimpleEmailService simpleEmailService;
    private final AdminConfig adminConfig;

    public List<TrelloBoardDTO> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCard createTrelloCard(final TrelloCardDTO trelloCardDTO) {
        CreatedTrelloCard newCard = trelloClient.createNewCard(trelloCardDTO);

        ofNullable(newCard).ifPresent(card -> simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        null,
                        SUBJECT,
                        "New card: " + trelloCardDTO.getName() + " has been created on your Trello account"
                )));

        return newCard;
    }
}
