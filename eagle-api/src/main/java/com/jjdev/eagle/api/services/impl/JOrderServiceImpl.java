package com.jjdev.eagle.api.services.impl;

import com.jjdev.eagle.api.entities.JOrder;
import com.jjdev.eagle.api.repositories.IOrderRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jjdev.eagle.api.services.IOrderService;
import java.util.List;

/**
 *
 * @author JGilson
 */
@Service
public class JOrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public JOrder create(JOrder order) {
        return this.orderRepository.save(order);
    }

    @Override
    public List<JOrder> readAll() {
        return this.orderRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Optional<JOrder> readById(Long id) {
        return Optional.ofNullable(this.orderRepository.findOne(id));
    }

    @Override
    public JOrder update(JOrder order) {
        return this.orderRepository.saveAndFlush(order);
    }

    @Override
    public void delete(Long id) {
        this.orderRepository.delete(id);
    }

}
