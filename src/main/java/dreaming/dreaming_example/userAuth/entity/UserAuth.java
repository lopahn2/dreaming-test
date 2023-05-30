package dreaming.dreaming_example.userAuth.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dreaming.dreaming_example.baseTime.BaseTimeEntity;
import dreaming.dreaming_example.userAuth.dto.UserAuthDto;
import dreaming.dreaming_example.userOfBoard.entity.UserOfBoard;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
public class UserAuth extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAuthId;

    private String email;

    private String password;

    private String passwordSalt;

    private Authority authority;

    @OneToMany(
            mappedBy = "userAuth",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    List<UserOfBoard> userOfBoards = new ArrayList<>();
    public UserAuthDto toDto() {
        return UserAuthDto.builder()
                .email(email)
                .password(password)
                .passwordSalt(passwordSalt)
                .authority(authority)
                .build();
    }


}
