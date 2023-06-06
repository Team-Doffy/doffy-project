package Doffy.server.like.entity;

import Doffy.server.community.entity.Reply;
import Doffy.server.community.entity.ReplyComment;
import Doffy.server.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reply_comment_like")
@Builder
public class ReplyCommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_comment_like_id")
    private long replyCommentLikeId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "reply_comment_id", nullable = false)
    private ReplyComment replyComment;

    @Column(name = "liked", nullable = false)
    private boolean commentLiked;
}
