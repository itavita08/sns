package com.example.sns.repository;

import com.example.sns.model.entity.CommentEntity;
import com.example.sns.model.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CommentEntityRepository extends JpaRepository<CommentEntity, Integer> {

    Page<CommentEntity> findAllByPost(PostEntity post, Pageable pageable);
    @Transactional
    @Modifying
    @Query("UPDATE CommentEntity entity SET entity.deletedAt = NOW() where entity.post =:post")
    void deleteAllByPost(@Param("post") PostEntity post);
}
