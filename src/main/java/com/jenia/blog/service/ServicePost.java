package com.jenia.blog.service;

import com.jenia.blog.model.Post;
import com.jenia.blog.model.User;

import java.util.List;
import java.util.Optional;


public interface ServicePost  {
    List<Post> findAllPosts();
    List<Post> findAllUserPosts(String username);
    Optional<Post> findById(Integer id);
    public Post save(Post post);
    public void delete(Post post);

}
