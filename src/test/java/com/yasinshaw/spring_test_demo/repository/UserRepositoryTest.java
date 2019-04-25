package com.yasinshaw.spring_test_demo.repository;

import com.yasinshaw.spring_test_demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void couldReturnUser_whenFindByUsername() {
        // given
        String userName = "testUser";
        User user = User.builder()
                .username(userName)
                .password("test")
                .build();
        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByUsername(userName);

        // then
        assertThat(found.getUsername()).isEqualTo(user.getUsername());
        assertThat(found.getId()).isNotNull();
    }

}