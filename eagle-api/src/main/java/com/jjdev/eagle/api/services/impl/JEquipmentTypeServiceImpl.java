package com.jjdev.eagle.api.services.impl;

import com.jjdev.eagle.api.entities.JEquipmentType;
import com.jjdev.eagle.api.repositories.IEquipmentTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jjdev.eagle.api.services.IEquipmentTypeService;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JGilson
 */
@Service
public class JEquipmentTypeServiceImpl implements IEquipmentTypeService {

    private static final Logger log = LoggerFactory.getLogger(JEquipmentTypeServiceImpl.class);

    @Autowired
    private IEquipmentTypeRepository equipmentTypeRepository;

    @Override
    public Optional<JEquipmentType> findById(Long id) {
        return Optional.ofNullable(this.equipmentTypeRepository.findOne(id));
    }

    @Override
    public List<JEquipmentType> findAll() {
        return this.equipmentTypeRepository.findAll();
    }

    @Override
    public JEquipmentType create(JEquipmentType equipmentType) {
        return this.equipmentTypeRepository.save(equipmentType);
    }

    @Override
    public JEquipmentType update(JEquipmentType equipmentType) {
        return this.equipmentTypeRepository.save(equipmentType);
    }

    @Override
    public void remove(Long id) {
        this.equipmentTypeRepository.delete(id);
    }

}
