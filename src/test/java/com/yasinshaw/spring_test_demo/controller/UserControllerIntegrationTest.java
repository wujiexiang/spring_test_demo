package com.yasinshaw.spring_test_demo.controller;

import com.yasinshaw.spring_test_demo.entity.User;
import com.yasinshaw.spring_test_demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserService userService;

    @Test
    void givenUsers_whenGetUsers_thenReturnJsonPage() throws Exception {
        Mockito.when(userService.getUsers(null)).thenReturn(getUsersPage());

        mvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[0].id").value(1L))
                .andExpect(jsonPath("$.content[1].username").value("user2"))
                .andExpect(jsonPath("$.content[2].password").doesNotExist()) // password should be hidden
                .andReturn();
    }

    private Page<User> getUsersPage() {
        List<User> users = List.of(
                User.builder().id(1L).username("user1").password("pwd1").build(),
                User.builder().id(2L).username("user2").password("pwd2").build(),
                User.builder().id(3L).username("user3").password("pwd3").build()
        );
        return new PageImpl<>(users);
    }
}