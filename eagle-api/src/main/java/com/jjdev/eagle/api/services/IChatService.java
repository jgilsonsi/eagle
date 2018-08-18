package com.jjdev.eagle.api.services;

import com.jjdev.eagle.api.entities.JClient;
import com.jjdev.eagle.api.entities.JEquipmentType;
import com.jjdev.eagle.api.entities.JOrder;

/**
 *
 * @author JGilson
 */
public interface IChatService {

    /**
     * Create order
     *
     * @param order
     * @return String
     */
    String createOrder(JOrder order);

    /**
     * Create or update client if exists
     *
     * @param client
     * @return String
     */
    String createOrUpdateClient(JClient client);

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
