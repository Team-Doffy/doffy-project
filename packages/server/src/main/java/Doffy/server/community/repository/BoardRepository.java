package Doffy.server.community.repository;

import Doffy.server.community.entity.Board;
import Doffy.server.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByUser(User user);
    Page<Board> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"comments", "replies", "replies.comments"})
    Optional<Board> findByIdWithCommentsAndReplies(Long boardId);
}
