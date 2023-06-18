package telegrambot.service.card;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import telegrambot.model.Card;
import telegrambot.model.dto.UpdateCardReqDto;
import telegrambot.model.dto.UpdateCardResDto;
import telegrambot.repository.CardRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public Card getByName(String name) {
        return cardRepository.getByName(name)
                .orElseThrow(() -> new IllegalStateException("Card is not exist."));
    }

    @Override
    public BigDecimal getBalance() {
        return null;
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void updateBalanceByName(BigDecimal amount, String name) {
        cardRepository.updateBalanceByName(amount, name);
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public boolean checkIfExistByName(String name) {
        Optional<Card> optionalCard = cardRepository.getByName(name);
        return optionalCard.isPresent();
    }

    @Override
    public UpdateCardResDto updateCard(UpdateCardReqDto updateCardReqDto) {
        Card card = cardRepository.getById(updateCardReqDto.getId());
        card.setName(updateCardReqDto.getName());
        card.setBalance(updateCardReqDto.getBalance());
        cardRepository.save(card);
        return new UpdateCardResDto(card.getId(), card.getName(), card.getBalance());
    }
}