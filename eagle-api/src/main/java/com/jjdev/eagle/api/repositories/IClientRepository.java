package com.jjdev.eagle.api.repositories;

import com.jjdev.eagle.api.entities.JClient;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JGilson
 */
public interface IClientRepository extends JpaRepository<JClient, Long> {

    @Transactional(readOnly = true)
    JClient findByChatId(String chatId);

    @Modifying
    @Transactional()
    @Query("UPDATE JClient c SET c.name = :name, c.gender = :gender, "
            + "c.lastVisit = :lastVisit WHERE chatId = :chatId")
    int update(@Param("name") String name, @Param("gender") String gender,
            @Param("lastVisit") Date lastVisit, @Param("chatId") String chatId);

}
