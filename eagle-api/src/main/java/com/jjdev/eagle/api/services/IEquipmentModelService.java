package com.jjdev.eagle.api.services;

import com.jjdev.eagle.api.entities.JEquipmentModel;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JGilson
 */
public interface IEquipmentModelService {

    /**
     * Create equipment model.
     *
     * @param equipmentModel
     * @return JEquipmentModel
     */
    JEquipmentModel create(JEquipmentModel equipmentModel);

    /**
     * Return list of equipment models.
     *
     * @return List<JEquipmentModel>
     */
    List<JEquipmentModel> readAll();

    /**
     * Return a equipment model by id.
     *
     * @param id
     * @return Optional<JEquipmentModel>
     */
    Optional<JEquipmentModel> readById(Long id);

    /**
     * Update a equipment model.
     *
     * @param equipmentModel
     * @return JEquipmentModel
     */
    JEquipmentModel update(JEquipmentModel equipmentModel);

    /**
     * Remove a equipment model.
     *
     * @param id
     */
    void delete(Long id);

}
