package uz.bsep.entities;
import lombok.*;
import lombok.experimental.FieldDefaults;
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TranslateJson {
    String uz;
    String ru;
    String en;
}
