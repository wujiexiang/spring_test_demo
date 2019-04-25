package com.yasinshaw.spring_test_demo.repository;

import com.yasinshaw.spring_test_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String userName);
}
