package com.example.exercise2.demo_exercise2.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.exercise2.demo_exercise2.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

 Optional<List<CommentEntity>> findByPostId(Integer postId);

}
