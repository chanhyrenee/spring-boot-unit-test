package com.example.exercise2.demo_exercise2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.exercise2.demo_exercise2.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  // javax.persistence.NonUniqueResultException
  List<UserEntity> findByEmailAndPhone(String email, String phone);

  @Query(value = "UPDATE Member SET email = :email WHERE user_id = :userId",nativeQuery = true)
  Boolean updateEmailByUserID(Integer userId, String email);
}
