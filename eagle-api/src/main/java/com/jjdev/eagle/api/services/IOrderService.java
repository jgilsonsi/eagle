package com.jjdev.eagle.api.services;

import com.jjdev.eagle.api.entities.JOrder;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JGilson
 */
public interface IOrderService {

    /**
     * Create order.
     *
     * @param order
     * @return JOrder
     */
    JOrder create(JOrder order);

    /**
     * Return a list of orders.
     *
     * @return List<JOrders>
     */
    List<JOrder> readAll();

    /**
     * Return order by id.
     *
     * @param id
     * @return Optional<JOrder>
     */
    Optional<JOrder> readById(Long id);

    /**
     * Update order.
     *
     * @param order
     * @return JOrder
     */
    JOrder update(JOrder order);

    /**
     * Remove order.
     *
     * @param id
     */
    void delete(Long id);

}
