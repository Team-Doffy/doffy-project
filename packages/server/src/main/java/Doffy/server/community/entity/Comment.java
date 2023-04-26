package Doffy.server.community.entity;

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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long commentId;

    private long parentId;

    @Enumerated(EnumType.STRING)
    private CommentType commentType;

    @Column(columnDefinition = "TEXT")
    private String commentBody;

    private LocalDateTime createdAt;

    public enum CommentType {
        BOARD, REPLY
    }

    public static CommentType getCommentTypeFromString(String commentTypeString) {
        return CommentType.valueOf(commentTypeString.toUpperCase());
    }

}
