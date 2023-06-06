package Doffy.server.community.entity;

import Doffy.server.global.audit.BaseEntity;
import Doffy.server.like.entity.ReplyLike;
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
@Table(name = "reply")
@Builder
public class Reply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private long replyId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(name = "reply_body")
    private String replyBody;

    @Column(name = "is_accepted")
    private boolean isAccepted;

    @Builder.Default
    @Column(name = "like_count", nullable = false)
    private int likeCount = 0;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "reply", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReplyComment> replyComments;

    @OneToMany(mappedBy = "reply", cascade = CascadeType.ALL)
    private List<ReplyLike> replyLikes;
}
