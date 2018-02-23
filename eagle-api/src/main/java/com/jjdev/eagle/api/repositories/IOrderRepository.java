package com.jjdev.eagle.api.repositories;

import com.jjdev.eagle.api.entities.JOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JGilson
 */
public interface IOrderRepository extends JpaRepository<JOrder, Long> {

}
