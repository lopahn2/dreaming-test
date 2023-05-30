package dreaming.dreaming_example.board.dto;

import dreaming.dreaming_example.board.entity.Board;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;



@Builder
@AllArgsConstructor(access=AccessLevel.PROTECTED)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
public class BoardDto {
    private String title;

    private String content;

    private int applyLimit;

    private LocalDateTime dueDate;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .applyLimit(applyLimit)
                .dueDate(dueDate)
                .build();
    }
}
