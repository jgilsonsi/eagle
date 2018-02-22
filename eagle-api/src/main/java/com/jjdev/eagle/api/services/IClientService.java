package com.jjdev.eagle.api.services;

import com.jjdev.eagle.api.entities.JClient;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JGilson
 */
public interface IClientService {

    /**
     * Create client.
     *
     * @param client
     * @return JClient
     */
    JClient create(JClient client);

    /**
     * Return list of equipment models.
     *
     * @return List<JEquipmentModel>
     */
    List<JClient> readAll();

    /**
     * Return client by id.
     *
     * @param id
     * @return Optional<JClient>
     */
    Optional<JClient> readById(Long id);

    /**
     * Update client.
     *
     * @param client
     * @return JClient
     */
    JClient update(JClient client);

    /**
     * Remove client.
     *
     * @param id
     */
    void delete(Long id);

}
