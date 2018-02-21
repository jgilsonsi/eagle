package com.jjdev.eagle.api.services;

import com.jjdev.eagle.api.entities.JEquipmentType;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JGilson
 */
public interface IEquipmentTypeService {

    /**
     * Return a equipment type by id.
     *
     * @param id
     * @return Optional<JEquipmentType>
     */
    Optional<JEquipmentType> findById(Long id);

    /**
     * Return list of equipments types.
     *
     * @return List<JEquipmentType>
     */
    List<JEquipmentType> findAll();

    /**
     * Create equipment type.
     *
     * @param equipmentType
     * @return JEquipmentType
     */
    JEquipmentType create(JEquipmentType equipmentType);

    /**
     * Remove a equipment type.
     *
     * @param id
     */
    void remove(Long id);

    /**
     * Update a equipment type.
     *
     * @param equipmentType
     * @return JEquipmentType
     */
    JEquipmentType update(JEquipmentType equipmentType);

}
