package dreaming.dreaming_example.board.dto;

import dreaming.dreaming_example.board.entity.Board;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Data
@Builder
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
