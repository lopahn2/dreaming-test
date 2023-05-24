package dreaming.dreaming_example.userOfBoard.dto;

import dreaming.dreaming_example.userOfBoard.entity.UserOfBoard;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserOfBoardDto {
    private Long boardId;

    private Long userAuthId;

    public UserOfBoard toEntity() {
        return UserOfBoard.builder()
                .boardId(boardId)
                .userAuthId(userAuthId)
                .build();

    }
}
