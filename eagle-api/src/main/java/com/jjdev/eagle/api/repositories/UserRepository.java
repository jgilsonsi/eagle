package com.jjdev.eagle.api.repositories;

import com.jjdev.eagle.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JGilson
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional(readOnly = true)
    User findByEmail(String email);

}
