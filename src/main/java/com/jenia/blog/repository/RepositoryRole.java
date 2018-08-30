package com.jenia.blog.repository;

import com.jenia.blog.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RepositoryRole extends JpaRepository<Role,Integer> {

    Role findByRole(@Param("role") String role);

}
