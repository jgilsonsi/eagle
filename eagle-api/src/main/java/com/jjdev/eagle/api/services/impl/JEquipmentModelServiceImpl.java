package com.jjdev.eagle.api.services.impl;

import com.jjdev.eagle.api.entities.JEquipmentModel;
import com.jjdev.eagle.api.repositories.IEquipmentModelRepository;
import com.jjdev.eagle.api.services.IEquipmentModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JGilson
 */
@Service
public class JEquipmentModelServiceImpl implements IEquipmentModelService {

    @Autowired
    private IEquipmentModelRepository equipmentModelRepository;

    @Override
    public JEquipmentModel create(JEquipmentModel equipmentModel) {
        return this.equipmentModelRepository.save(equipmentModel);
    }

    @Override
    public List<JEquipmentModel> readAll() {
        return this.equipmentModelRepository.findAll();
    }

    @Override
    public Optional<JEquipmentModel> readById(Long id) {
        return Optional.ofNullable(this.equipmentModelRepository.findOne(id));
    }

    @Override
    public JEquipmentModel update(JEquipmentModel equipmentModel) {
        return this.equipmentModelRepository.save(equipmentModel);
    }

    @Override
    public void delete(Long id) {
        this.equipmentModelRepository.delete(id);
    }

}
