package Doffy.server.community.entity;

import Doffy.server.global.audit.BaseEntity;
import Doffy.server.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reply_comment")
@Builder
public class ReplyComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_comment_id")
    private long replyCommentId;

    @Column(columnDefinition = "TEXT")
    private String replyCommentBody;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_id")
    private Reply reply;

}
