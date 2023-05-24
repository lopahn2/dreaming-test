package dreaming.dreaming_example.userAuth.entity;

import dreaming.dreaming_example.baseTime.BaseTimeEntity;
import dreaming.dreaming_example.userAuth.dto.UserAuthDto;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Builder
public class UserAuth extends BaseTimeEntity {

    private String email;

    private String password;

    private String passwordSalt;

    private Authority authority;

    public UserAuthDto toDto() {
        return UserAuthDto.builder()
                .email(email)
                .password(password)
                .passwordSalt(passwordSalt)
                .authority(authority)
                .build();
    }
}
