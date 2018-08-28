package com.jjdev.eagle.api.repositories;

import com.jjdev.eagle.api.entities.JOrder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JGilson
 */
public interface IOrderRepository extends JpaRepository<JOrder, Long> {

    @Transactional(readOnly = true)
    List<JOrder> findAllByOrderByIdDesc();

}
