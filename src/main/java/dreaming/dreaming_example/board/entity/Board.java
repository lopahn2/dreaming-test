package dreaming.dreaming_example.board.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import dreaming.dreaming_example.baseTime.BaseTimeEntity;
import dreaming.dreaming_example.board.dto.BoardDto;
import dreaming.dreaming_example.userOfBoard.entity.UserOfBoard;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String title;

    private String content;

    private int applyLimit;

    private LocalDateTime dueDate;

    @OneToMany(
            mappedBy = "board",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    List<UserOfBoard> userAuthes = new ArrayList<>();


    public BoardDto toDto() {
        return BoardDto.builder()
                .title(title)
                .content(content)
                .applyLimit(applyLimit)
                .dueDate(dueDate)
                .build();
    }

    public void updateBoard (BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
        this.applyLimit = boardDto.getApplyLimit();
        this.dueDate = boardDto.getDueDate();
    }

}
