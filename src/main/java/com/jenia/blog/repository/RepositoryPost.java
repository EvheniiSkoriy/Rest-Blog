package com.jenia.blog.repository;

import com.jenia.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryPost extends JpaRepository<Post, Integer> {


}
