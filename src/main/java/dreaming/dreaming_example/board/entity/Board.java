package dreaming.dreaming_example.board.entity;


import dreaming.dreaming_example.baseTime.BaseTimeEntity;
import dreaming.dreaming_example.board.dto.BoardDto;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import javax.persistence.Entity;

@Entity
@Data
@Builder
public class Board extends BaseTimeEntity {

    private String title;

    private String content;

    private int applyLimit;

    private LocalDateTime dueDate;

    public BoardDto toDto() {
        return BoardDto.builder()
                .title(title)
                .content(content)
                .applyLimit(applyLimit)
                .dueDate(dueDate)
                .build();
    }

}
