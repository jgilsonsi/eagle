package com.jjdev.eagle.api.services.impl;

import com.jjdev.eagle.api.entities.JUser;
import java.util.Optional;
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

    @Autowired
    private IUserRepository userRepository;

    @Override
    public JUser create(JUser user) {
        return this.userRepository.save(user);
    }

    @Override
    public Optional<JUser> readByEmail(String email) {
        return Optional.ofNullable(this.userRepository.findByEmail(email));
    }

    @Override
    public Optional<JUser> readById(Long id) {
        return Optional.ofNullable(this.userRepository.findOne(id));
    }

    @Override
    public boolean update(JUser user) {
        int status = this.userRepository.update(user.getId(), user.getName(),
                user.getPassword(), user.getRole());

        return status == 1;
    }

    @Override
    public void delete(Long id) {
        this.userRepository.delete(id);
    }

}
