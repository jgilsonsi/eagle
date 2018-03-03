package com.jjdev.eagle.api.repositories;

import com.jjdev.eagle.api.entities.JClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JGilson
 */
public interface IClientRepository extends JpaRepository<JClient, Long> {

    @Transactional(readOnly = true)
    JClient findByChatId(String chatId);

}
