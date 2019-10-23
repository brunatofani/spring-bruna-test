package com.bruna.spring.test.repository;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class UserRepositoryTest {

    @Mock
    UserRepository userRepository;

    @Test
    void testGet() {
        assertEquals("Hello JUnit 5", 1,userRepository.findAll().size());
    }
}
