package uz.bsep.dtos.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ExceptionDto {

    LocalDateTime timestamp;
    String path;
    Integer status;
    String message;

    @Builder
    public ExceptionDto(String path, Integer status, String message) {
        this.path = path;
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
