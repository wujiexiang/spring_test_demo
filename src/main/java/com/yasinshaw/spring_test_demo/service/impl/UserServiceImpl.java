package com.yasinshaw.spring_test_demo.service.impl;

import com.yasinshaw.spring_test_demo.entity.User;
import com.yasinshaw.spring_test_demo.repository.UserRepository;
import com.yasinshaw.spring_test_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(User.builder()
        .username("no such user")
        .build());
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
