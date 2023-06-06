package Doffy.server.community.entity;

import Doffy.server.global.audit.BaseEntity;
import Doffy.server.like.entity.BoardCommentLike;
import Doffy.server.like.entity.BoardLike;
import Doffy.server.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "board_comment")
@Builder
public class BoardComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_comment_id")
    private long boardCommentId;

    @Column(columnDefinition = "TEXT")
    private String boardCommentBody;

    @Column
    @Builder.Default
    private int likeCount = 0;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "boardComment", cascade = CascadeType.ALL)
    private List<BoardCommentLike> boardCommentLikes;

}
