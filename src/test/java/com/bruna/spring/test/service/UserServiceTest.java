package com.bruna.spring.test.service;

import com.bruna.spring.test.model.User;
import com.bruna.spring.test.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService = new UserService();

    @Mock
    UserRepository userRepository = mock(UserRepository.class) ;

    @Test
    public void testFindUserByIdShouldFind() {
        User user = getUser();
        when(userRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(user));
        assertEquals("Teste User findUserById - ShouldFind", user.getName(), userService.findUserById(user.getIdUser()).getName());
    }

    @Test
    public void testFindUserByIdShouldNotFind() {
        User user = getUser();
        when(userRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(user));
        assertNotEquals("Teste User findUserById - ShouldNotFind", getUser1().getName(), userService.findUserById(user.getIdUser()).getName());
    }

    @Test
    public void testGetUserByNameShouldFindOne() {
        User user = getUser();
        when(userRepository.findByName(anyString())).thenReturn(user);
        assertEquals("Teste User findUserById - ShouldFind", user.getIdUser(), userService.getUserByName(user.getName()).getIdUser());
    }

    @Test
    public void testGetUserByNameShouldNotFind() {
        User user = getUser();
        when(userRepository.findByName(anyString())).thenReturn(user);
        assertNotEquals("Teste User findUserById - ShouldNotFind", getUser1().getIdUser(), userService.getUserByName(user.getName()).getIdUser());
    }

    private User getUser() {
        User user = new User();
        user.setName("test");
        user.setIdUser(2L);
        return user;
    }

    private User getUser1() {
        User user = new User();
        user.setName("test1");
        user.setIdUser(1L);
        return user;
    }
}
