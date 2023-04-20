package Doffy.server.community.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int commentId;

    @Column(name = "comment_body")
    private String commentBody;

    @Column(name = "comment_likes")
    private int commentLikes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
