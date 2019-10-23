package com.bruna.spring.test.service;

import com.bruna.spring.test.model.User;
import com.bruna.spring.test.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService = mock(UserService.class);

    @Mock
    UserRepository userRepository = mock(UserRepository.class) ;

    @Test
    public void testfindUserByIdShouldFind() {
        Long id = 1L;
        User user = getUser();
        when(userRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(user));
        assertEquals("Teste User findUserById", user.getName(), userService.findUserById(id).getName());
    }

    private User getUser() {
        User user = new User();
        user.setName("test");
        user.setIdUser(1L);
        return user;
    }
}
