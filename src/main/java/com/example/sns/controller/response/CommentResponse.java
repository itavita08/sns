package com.example.sns.controller.response;

import com.example.sns.model.Comment;
import com.example.sns.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class CommentResponse {

    private Integer id;
    private String comment;
    private String userName;
    private Integer postId;
    private Timestamp registerAt;
    private Timestamp updateAt;
    private Timestamp deletedAt;

    public static CommentResponse fromComment(Comment post){

        return new CommentResponse(
                post.getId(),
                post.getComment(),
                post.getUserName(),
                post.getPostId(),
                post.getRegisterAt(),
                post.getUpdateAt(),
                post.getDeletedAt()
        );
    }
}
