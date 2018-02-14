package com.jjdev.eagle.api.services.impl;

import com.jjdev.eagle.api.entities.JUser;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jjdev.eagle.api.repositories.IUserRepository;
import com.jjdev.eagle.api.services.IUserService;

/**
 *
 * @author JGilson
 */
@Service
public class JUserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(JUserServiceImpl.class);

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<JUser> findById(Long id) {
        return Optional.ofNullable(this.userRepository.findOne(id));
    }

    @Override
    public Optional<JUser> findByEmail(String email) {
        return Optional.ofNullable(this.userRepository.findByEmail(email));
    }

    @Override
    public JUser create(JUser user) {
        return this.userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        this.userRepository.delete(id);
    }

}
