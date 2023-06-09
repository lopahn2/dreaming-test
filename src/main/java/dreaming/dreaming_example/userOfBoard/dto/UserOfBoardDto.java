package dreaming.dreaming_example.userOfBoard.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dreaming.dreaming_example.board.entity.Board;
import dreaming.dreaming_example.userAuth.entity.UserAuth;
import dreaming.dreaming_example.userOfBoard.entity.UserOfBoard;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@AllArgsConstructor(access= AccessLevel.PROTECTED)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
public class UserOfBoardDto {

    private UserAuth userAuth;

    private Board board;

    public UserOfBoard toEntity() {
        return UserOfBoard.builder()
                .board(board)
                .userAuth(userAuth)
                .build();

    }
}
