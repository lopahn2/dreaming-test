package dreaming.dreaming_example.userOfBoard.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dreaming.dreaming_example.board.entity.Board;
import dreaming.dreaming_example.userAuth.entity.Authority;
import dreaming.dreaming_example.userAuth.entity.UserAuth;
import dreaming.dreaming_example.userOfBoard.entity.UserOfBoard;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor(access= AccessLevel.PROTECTED)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
public class UserOfBoardFilteredDto {

    private Long userAuthId;
    private String email;
    private Authority authority;
    private Long boardId;
    private String title;
    private LocalDateTime dueDate;


}
