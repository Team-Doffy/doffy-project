package Doffy.server.user.repository;

import Doffy.server.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

    public User findByUserId(Long userId);

    public User findByUsername(String username);

    public User findByNickname(String nickname);
}
