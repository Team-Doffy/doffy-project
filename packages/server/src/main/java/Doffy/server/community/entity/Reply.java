package Doffy.server.community.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reply")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private int replyId;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Column(name = "reply_body")
    private String replyBody;

    @Column(name = "reply_likes")
    private int replyLikes;

    @Column(name = "is_accepted")
    private boolean isAccepted;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}