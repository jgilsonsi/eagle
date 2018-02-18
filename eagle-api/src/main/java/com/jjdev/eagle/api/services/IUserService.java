package com.jjdev.eagle.api.services;

import com.jjdev.eagle.api.entities.JUser;
import java.util.Optional;

/**
 *
 * @author JGilson
 */
public interface IUserService {

    /**
     * Return a user by id.
     *
     * @param id
     * @return Optional<JUser>
     */
    Optional<JUser> findById(Long id);

    /**
     * Return a user by email.
     *
     * @param email
     * @return Optional<JUser>
     */
    Optional<JUser> findByEmail(String email);

    /**
     * Create new user.
     *
     * @param user
     * @return JUser
     */
    JUser create(JUser user);

    /**
     * Update a user.
     *
     * @param user
     * @return return true if the action is ok
     */
    boolean update(JUser user);

    /**
     * Remove a user.
     *
     * @param id
     */
    void remove(Long id);
}
