package com.jjdev.eagle.api.services.impl;

import com.jjdev.eagle.api.entities.User;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jjdev.eagle.api.repositories.UserRepository;
import com.jjdev.eagle.api.services.UserService;

/**
 *
 * @author JGilson
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(this.userRepository.findOne(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(this.userRepository.findByEmail(email));
    }

    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        this.userRepository.delete(id);
    }

}
