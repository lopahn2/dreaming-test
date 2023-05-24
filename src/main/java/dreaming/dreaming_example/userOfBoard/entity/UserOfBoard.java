package dreaming.dreaming_example.userOfBoard.entity;

import dreaming.dreaming_example.baseTime.BaseTimeEntity;
import dreaming.dreaming_example.userOfBoard.dto.UserOfBoardDto;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Builder
public class UserOfBoard extends BaseTimeEntity {

    private Long boardId;

    private Long userAuthId;

    public UserOfBoardDto toDto() {
        return UserOfBoardDto.builder()
                .boardId(boardId)
                .userAuthId(userAuthId)
                .build();
    }
}
