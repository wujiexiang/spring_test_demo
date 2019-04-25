package com.yasinshaw.spring_test_demo.service;

import com.yasinshaw.spring_test_demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User getUserById(Long id);

    Page<User> getUsers(Pageable pageable);
}
