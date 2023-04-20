package Doffy.server.community.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private int boardId;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "reply_id")
    private Reply reply;

    @Column(name = "title")
    private String title;

    @Column(name = "board_body")
    private String boardBody;

    @Column(name = "board_likes")
    private int boardLikes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // constructors, getters and setters
}
