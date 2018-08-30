package com.jenia.blog.service.implementation;

import com.jenia.blog.model.Post;
import com.jenia.blog.model.User;
import com.jenia.blog.repository.RepositoryPost;
import com.jenia.blog.service.ServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements ServicePost {

    private final RepositoryPost postRepository;

    @Autowired
    public PostServiceImpl(RepositoryPost postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findAllUserPosts(String username) {
        List<Post> allPosts=postRepository.findAll();
        List<Post> userPosts=new ArrayList<>();

        for(Post post:allPosts){
            if(post.getUser().getUsername().equals(username)){
                userPosts.add(post);
            }
        }
        return userPosts;
    }

    @Override
    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }
}
