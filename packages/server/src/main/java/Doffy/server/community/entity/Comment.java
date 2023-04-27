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
@Table(name = "comment")
@Builder
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long commentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private long parentId;

    @Enumerated(EnumType.STRING)
    private CommentType commentType;

    @Column(columnDefinition = "TEXT")
    private String commentBody;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    public enum CommentType {
        BOARD, REPLY
    }

    public static CommentType getCommentTypeFromString(String commentTypeString) {
        return CommentType.valueOf(commentTypeString.toUpperCase());
    }

}
