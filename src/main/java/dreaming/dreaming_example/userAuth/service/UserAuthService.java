package dreaming.dreaming_example.userAuth.service;

import dreaming.dreaming_example.userAuth.dto.UserAuthDto;
import dreaming.dreaming_example.userAuth.entity.UserAuth;

import java.util.List;

public interface UserAuthService {
    public UserAuth signOut(Long id);
    public UserAuth signUp(UserAuthDto userAuthDto);
    public List<UserAuth> getAllUserAuthInfo();
}
