package telegrambot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import telegrambot.config.multitenancy.TenantManager;
import telegrambot.model.dto.card.CardReqDto;
import telegrambot.model.dto.card.CardResDto;
import telegrambot.model.dto.common.ResponseDto;
import telegrambot.service.card.CardService;

import static telegrambot.model.dto.common.ResponseDto.getDto;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/card")
public class CardController {

    private final CardService cardService;
    private final TenantManager tenantManager;

    @PutMapping(value = "/{dbName}/{id}")
    public ResponseEntity<ResponseDto<CardResDto>> update(@PathVariable String dbName,
                                                         @PathVariable Long id,
                                                         @RequestBody CardReqDto cardReqDto) {
        tenantManager.switchDataSource(dbName, true);
        cardReqDto.setId(id);
        return ResponseEntity.ok(getDto(cardService.updateCard(cardReqDto)));
    }

    @PostMapping(value = "/{dbName}")
    public ResponseEntity<ResponseDto<CardResDto>> create(@PathVariable String dbName,
                                             @RequestBody CardReqDto cardReqDTO) {
        tenantManager.switchDataSource(dbName, true);
        CardResDto card = cardService.createCard(dbName, cardReqDTO);

        return ResponseEntity.ok(getDto(card));
    }

    @GetMapping(value = "/{dbName}/{id}")
    public ResponseEntity<ResponseDto<CardResDto>> read(@PathVariable String dbName,
                                           @PathVariable Long id) {
        tenantManager.switchDataSource(dbName, true);
        CardResDto cardNyName = cardService.getCardById(id);
        return ResponseEntity.ok(getDto(cardNyName));
    }

    @DeleteMapping(value = "/{dbName}/{id}")
    public ResponseEntity<ResponseDto<String>> delete(@PathVariable String dbName, @PathVariable Long id) {
        tenantManager.switchDataSource(dbName, true);
        cardService.deleteCard(id);
        return ResponseEntity.ok(getDto("Your card has been successfully deleted."));
    }
}