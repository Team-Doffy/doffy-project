package Doffy.server.community.repository;

import Doffy.server.community.entity.Reply;
import Doffy.server.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByUser(User user);
    Page<Reply> findAll(Pageable pageable);
}
