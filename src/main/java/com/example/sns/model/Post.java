package com.example.sns.model;

import com.example.sns.model.entity.PostEntity;
import com.example.sns.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;


@Getter
@AllArgsConstructor
public class Post {

    private Integer id;
    private String title;
    private String body;
    private User user;
    private Timestamp registerAt;
    private Timestamp updateAt;
    private Timestamp deletedAt;

    public static Post fromEntity(PostEntity entity) {
        return new Post(
                entity.getId(),
                entity.getTitle(),
                entity.getBody(),
                User.fromEntity(entity.getUser()),
                entity.getRegisterAt(),
                entity.getUpdateAt(),
                entity.getDeletedAt()
        );
    }
}
