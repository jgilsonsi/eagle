package com.jjdev.eagle.api.repositories;

import com.jjdev.eagle.api.entities.JUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JGilson
 */
public interface IUserRepository extends JpaRepository<JUser, Long> {

    @Transactional(readOnly = true)
    JUser findByEmail(String email);

}
