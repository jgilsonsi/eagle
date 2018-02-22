package com.jjdev.eagle.api.services.impl;

import com.jjdev.eagle.api.entities.JClient;
import com.jjdev.eagle.api.repositories.IClientRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jjdev.eagle.api.services.IClientService;
import java.util.List;

/**
 *
 * @author JGilson
 */
@Service
public class JClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Override
    public JClient create(JClient client) {
        return this.clientRepository.save(client);
    }

    @Override
    public List<JClient> readAll() {
        return this.clientRepository.findAll();
    }

    @Override
    public Optional<JClient> readById(Long id) {
        return Optional.ofNullable(this.clientRepository.findOne(id));
    }

    @Override
    public JClient update(JClient client) {
        return this.clientRepository.saveAndFlush(client);
    }

    @Override
    public void delete(Long id) {
        this.clientRepository.delete(id);
    }

}
