package com.jjdev.eagle.api.services.impl;

import com.jjdev.eagle.api.entities.JEquipmentType;
import com.jjdev.eagle.api.repositories.IEquipmentTypeRepository;
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

    @Autowired
    private IEquipmentTypeRepository equipmentTypeRepository;

    @Override
    public JEquipmentType create(JEquipmentType equipmentType) {
        return this.equipmentTypeRepository.save(equipmentType);
    }

    @Override
    public List<JEquipmentType> readAll() {
        return this.equipmentTypeRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Optional<JEquipmentType> readById(Long id) {
        return Optional.ofNullable(this.equipmentTypeRepository.findOne(id));
    }

    @Override
    public JEquipmentType update(JEquipmentType equipmentType) {
        return this.equipmentTypeRepository.save(equipmentType);
    }

    @Override
    public void delete(Long id) {
        this.equipmentTypeRepository.delete(id);
    }

}
