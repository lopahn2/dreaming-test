package dreaming.dreaming_example.userAuth.repository;

import dreaming.dreaming_example.board.entity.Board;
import dreaming.dreaming_example.userAuth.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
    Optional<UserAuth> findById(Long userAuthId);
}
