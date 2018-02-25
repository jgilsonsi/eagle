package com.jjdev.eagle.api.services;

import com.jjdev.eagle.api.entities.JEquipmentType;

/**
 *
 * @author JGilson
 */
public interface IChatService {

    /**
     * Return equipment types in 'Json
     *
     * @return String
     */
    String readEquipmentTypes();

    /**
     * Return equipment models in 'Json
     *
     * @param equipmentType
     * @return String
     */
    String readEquipmentModels(JEquipmentType equipmentType);

}
