package com.jjdev.eagle.api.services;

import com.jjdev.eagle.api.entities.User;
import java.util.Optional;

/**
 *
 * @author JGilson
 */
public interface UserService {

    /**
     * Return a User by id.
     *
     * @param id
     * @return Optional<User>
     */
    Optional<User> findById(Long id);

    /**
     * Return a User by email.
     *
     * @param email
     * @return Optional<User>
     */
    Optional<User> findByEmail(String email);

    /**
     * Create new User.
     *
     * @param User
     * @return User
     */
    User create(User user);

    /**
     * Remove a user.
     *
     * @param id
     */
    void remove(Long id);

}
