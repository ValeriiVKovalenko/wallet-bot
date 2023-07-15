package telegrambot.model.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto<T>{
    private T body;
    private String error;

    private ResponseDto(T body){
        this.body = body;
        this.error = null;
    }

    private ResponseDto(String msg){
        this.body = null;
        this.error = msg;
    }

    public static <T>ResponseDto<T> getDto(T body){
        return new ResponseDto<>(body);
    }

    public static <T>ResponseDto<T> getErrorDto(String body){
        return new ResponseDto<>(body);
    }
}
