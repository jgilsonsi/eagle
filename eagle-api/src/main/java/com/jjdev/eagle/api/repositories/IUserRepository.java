package com.jjdev.eagle.api.repositories;

import com.jjdev.eagle.api.entities.JUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JGilson
 */
public interface IUserRepository extends JpaRepository<JUser, Long> {

    @Transactional(readOnly = true)
    JUser findByEmail(String email);

    @Modifying
    @Transactional()
    @Query("UPDATE JUser u SET u.name = :name, u.password = :password, u.role = :role WHERE id = :id")
    int update(@Param("id") Long id, @Param("name") String name,
            @Param("password") String password, @Param("role") String role);
}
