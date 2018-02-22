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
     * Create equipment type.
     *
     * @param equipmentType
     * @return JEquipmentType
     */
    JEquipmentType create(JEquipmentType equipmentType);

    /**
     * Return list of equipment types.
     *
     * @return List<JEquipmentType>
     */
    List<JEquipmentType> readAll();

    /**
     * Return equipment type by id.
     *
     * @param id
     * @return Optional<JEquipmentType>
     */
    Optional<JEquipmentType> readById(Long id);

    /**
     * Update equipment type.
     *
     * @param equipmentType
     * @return JEquipmentType
     */
    JEquipmentType update(JEquipmentType equipmentType);

    /**
     * Remove equipment type.
     *
     * @param id
     */
    void delete(Long id);

}
