package com.jjdev.eagle.api.services;

import com.jjdev.eagle.api.entities.JUser;
import java.util.Optional;

/**
 *
 * @author JGilson
 */
public interface IUserService {

    /**
     * Return a JUser by id.
     *
     * @param id
     * @return Optional<User>
     */
    Optional<JUser> findById(Long id);

    /**
     * Return a JUser by email.
     *
     * @param email
     * @return Optional<User>
     */
    Optional<JUser> findByEmail(String email);

    /**
     * Create new JUser.
     *
     * @param User
     * @return JUser
     */
    JUser create(JUser user);

    /**
     * Remove a user.
     *
     * @param id
     */
    void remove(Long id);

}
