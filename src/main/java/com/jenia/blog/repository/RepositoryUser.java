package com.jenia.blog.repository;

import com.jenia.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RepositoryUser extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(@Param("username") String username);
}
