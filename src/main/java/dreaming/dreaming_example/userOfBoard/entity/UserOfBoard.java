package dreaming.dreaming_example.userOfBoard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dreaming.dreaming_example.baseTime.BaseTimeEntity;
import dreaming.dreaming_example.board.entity.Board;
import dreaming.dreaming_example.userAuth.entity.UserAuth;
import dreaming.dreaming_example.userOfBoard.dto.UserOfBoardDto;
import dreaming.dreaming_example.userOfBoard.dto.UserOfBoardFilteredDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
public class UserOfBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userOfBoardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_auth_id")
    private UserAuth userAuth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    public UserOfBoardDto toDto() {
        return UserOfBoardDto.builder()
                .board(board)
                .userAuth(userAuth)
                .build();
    }

    public UserOfBoardFilteredDto toFilteredDto() {
        return UserOfBoardFilteredDto.builder()
                .userAuthId(userAuth.getUserAuthId())
                .email(userAuth.getEmail())
                .authority(userAuth.getAuthority())
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .dueDate(board.getDueDate())
                .build();
    }

}
