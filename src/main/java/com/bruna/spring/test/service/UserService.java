package com.bruna.spring.test.service;

import com.bruna.spring.test.model.User;
import com.bruna.spring.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {

    private final static Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUser () {
        return userRepository.findAll();
    }

    public User findUserById (Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByName(String name) {
        LOGGER.info("getName");
        return userRepository.findByName(name);
    }

    @Transient
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Transient
    public User updateUser(Long id, User user) {
        Optional<User> oldUser = userRepository.findById(id);

        if (oldUser.isPresent()) {
            oldUser.get().setName(user.getName());
            return saveUser(oldUser.get());
        }
        return null;
    }

    @Transient
    public boolean deleteUser (Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            return false;
        }
        userRepository.delete(user.get());
        return true;
    }
}
