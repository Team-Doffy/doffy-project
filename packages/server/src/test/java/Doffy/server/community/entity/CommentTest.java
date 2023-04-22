package Doffy.server.community.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CommentTest {

    @Test
    public void testGettersAndSetters(){
        // given
        Comment comment = new Comment();
        int commentId = -4;
        String commentBody = "TEST";
        int commentLikes = 550;

        // when
        comment.setCommentId(commentId);
        comment.setCommentBody(commentBody);
        comment.setCommentLikes(commentLikes);

        // then
        assertThat(comment.getCommentId()).isEqualTo(commentId);
        assertThat(comment.getCommentBody()).isEqualTo(commentBody);
        assertThat(comment.getCommentLikes()).isEqualTo(commentLikes);
    }
}
