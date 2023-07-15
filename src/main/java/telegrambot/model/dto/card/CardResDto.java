package telegrambot.model.dto.card;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardResDto {
    private Long id;
    private String name;
    private BigDecimal balance;
    private boolean isDeleted;
}