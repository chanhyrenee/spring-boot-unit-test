package com.example.exercise2.demo_exercise2.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.exercise2.demo_exercise2.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

  Optional<List<PostEntity>> findByUserId(Integer userId);
}
