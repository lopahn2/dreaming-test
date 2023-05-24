package dreaming.dreaming_example.userAuth.dto;

import dreaming.dreaming_example.userAuth.entity.Authority;
import dreaming.dreaming_example.userAuth.entity.UserAuth;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAuthDto {
    private String email;

    private String password;

    private String passwordSalt;

    private Authority authority;

    public UserAuth toEntity() {
        return UserAuth.builder()
                .email(email)
                .password(password)
                .passwordSalt(passwordSalt)
                .authority(authority)
                .build();
    }
}
