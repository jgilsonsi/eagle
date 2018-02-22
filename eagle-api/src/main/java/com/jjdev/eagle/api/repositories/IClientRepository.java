package com.jjdev.eagle.api.repositories;

import com.jjdev.eagle.api.entities.JClient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JGilson
 */
public interface IClientRepository extends JpaRepository<JClient, Long> {

}
