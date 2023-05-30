package dreaming.dreaming_example.userAuth.service;

import dreaming.dreaming_example.board.entity.Board;
import dreaming.dreaming_example.userAuth.dto.UserAuthDto;
import dreaming.dreaming_example.userAuth.entity.UserAuth;
import dreaming.dreaming_example.userAuth.repository.UserAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserAuthServiceImpl implements UserAuthService {

    private final UserAuthRepository userAuthRepository;

    @Override
    public UserAuth signOut(Long id) {
        UserAuth resultOfFindUserAuth = userAuthRepository.findById(id).orElseThrow(
                () -> new RuntimeException("존재하지 않는 사용자의 식별자 입니다.")
        );

        userAuthRepository.delete(resultOfFindUserAuth);
        return resultOfFindUserAuth;
    }

    @Override
    public UserAuth signUp(UserAuthDto userAuthDto) {
        userAuthRepository.save(userAuthDto.toEntity());
        return userAuthDto.toEntity();
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserAuth> getAllUserAuthInfo() {
        return userAuthRepository.findAll();
    }
}
