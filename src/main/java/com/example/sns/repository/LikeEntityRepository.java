package com.example.sns.repository;

import com.example.sns.model.entity.LikeEntity;
import com.example.sns.model.entity.PostEntity;
import com.example.sns.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikeEntityRepository extends JpaRepository<LikeEntity, Integer> {

    Optional<LikeEntity> findByUserAndPost(UserEntity user, PostEntity post);
    @Query(value = "SELECT COUNT(*) FROM LikeEntity entity where entity.post =: post")
    Integer countByPost(@Param("post") PostEntity post);
}