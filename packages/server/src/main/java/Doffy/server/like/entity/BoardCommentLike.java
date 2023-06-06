package Doffy.server.like.entity;

import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.BoardComment;
import Doffy.server.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "board_comment_like")
@Builder
public class BoardCommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_comment_like_id")
    private long boardCommentLikeId;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_comment_id", nullable = false)
    private BoardComment boardComment;

    @Column(name = "liked", nullable = false)
    private boolean commentLiked;
}
