package com.example.sns.model.entity;

import com.example.sns.model.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "\"posts\"")
@SQLDelete(sql = "UPDATE \"posts\" SET deleted_at = NOW() where id=?")
@Where(clause = "deleted_at is NULL")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "register_at")
    private Timestamp registerAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    void registerAt() {
        this.registerAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    void updateAt() {
        this.updateAt = Timestamp.from(Instant.now());
    }

    public static PostEntity of(String title, String body, UserEntity userEntity){

        PostEntity entity = new PostEntity();
        entity.setTitle(title);
        entity.setBody(body);
        entity.setUser(userEntity);

        return entity;
    }
}
