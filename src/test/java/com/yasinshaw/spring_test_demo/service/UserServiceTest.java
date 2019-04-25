package com.yasinshaw.spring_test_demo.service;

import com.yasinshaw.spring_test_demo.entity.User;
import com.yasinshaw.spring_test_demo.repository.UserRepository;
import com.yasinshaw.spring_test_demo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Test
    void shouldUserRepositoryNotNull_whenAddedMockAnnotation() {
        assertThat(userRepository).isNotNull();
    }

    @Test
    public void couldGetUser_whenIdExists() {
        when(userRepository.findById(1L))
                .thenReturn(Optional.of(User.builder()
                        .id(1L)
                        .username("username")
                        .password("password")
                        .build()));

        User found = userService.getUserById(1L);

        assertThat(found.getId()).isEqualTo(1L);
        assertThat(found.getUsername()).isEqualTo("username");
    }
}
