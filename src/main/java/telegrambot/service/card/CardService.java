package telegrambot.service.card;

import telegrambot.model.dto.card.CardReqDto;
import telegrambot.model.dto.card.CardResDto;
import telegrambot.model.entity.Card;

import java.math.BigDecimal;
import java.util.List;

public interface CardService {

    Card getByName(String name);

    Card createCard(Card card);

    Card updateBalanceByName(BigDecimal amount, String name);

    List<Card> getAll();

    boolean checkIfExistByName(String name);

    CardResDto updateCard(CardReqDto idCodeNameDTO);

    CardResDto createCard(String dbName, CardReqDto cardReqDto);

    CardResDto getCardById(Long id);

    void deleteCard(Long id);
}