package com.jjdev.eagle.api.controllers;

import com.jjdev.eagle.api.entities.JClient;
import com.jjdev.eagle.api.entities.JEquipmentModel;
import com.jjdev.eagle.api.entities.JEquipmentType;
import com.jjdev.eagle.api.entities.JOrder;
import com.jjdev.eagle.api.services.IChatService;
import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JGilson
 */
@RestController
@RequestMapping("/api/v1/chat")
@CrossOrigin(origins = "*")
public class JChatController {

    @Autowired
    private IChatService chatService;

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    private static final Logger log = LoggerFactory.getLogger(JChatController.class);

    public JChatController() {
    }

    /**
     * Create order.
     *
     * @param initialDate
     * @param finalDate
     * @param equipmentModelId
     * @param clientId
     * @return String
     */
    @PostMapping(value = "/order/{initialDate}/{finalDate}/{equipmentModelId}/{clientId}")
    @ResponseBody
    public String createOrder(
            @PathVariable("initialDate") String initialDate,
            @PathVariable("finalDate") String finalDate,
            @PathVariable("equipmentModelId") String equipmentModelId,
            @PathVariable("clientId") String clientId) {

        log.info("Creating order by Chat whith initialDate: {}, finalDate: {}, "
                + "equipmentModelId: {}, clientId: {}.",
                initialDate, finalDate, equipmentModelId, clientId);

        JOrder order;
        try {
            order = new JOrder();
            order.setInitialDate(formatter.parse(initialDate));
            order.setFinalDate(formatter.parse(finalDate));
            JEquipmentModel equipmentModel = new JEquipmentModel();
            equipmentModel.setId(Long.valueOf(equipmentModelId));
            order.setEquipmentModel(equipmentModel);
            JClient client = new JClient();
            client.setId(Long.parseLong(clientId));
            order.setClient(client);
        } catch (Exception e) {
            order = null;
            log.error("Incorrect object format: order");
        }

        return this.chatService.createOrder(order);
    }

    /**
     * Create or update client if exists.
     *
     * @param firstName
     * @param lastName
     * @param gender
     * @param chatId
     * @return String
     */
    @PostMapping(value = "/client/{firstName}/{lastName}/{gender}/{chatId}")
    @ResponseBody
    public String createOrUpdateClient(
            @PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName,
            @PathVariable("gender") String gender,
            @PathVariable("chatId") String chatId) {

        String name = removePlus(firstName + " " + lastName);

        log.info("Creating client by Chat whith name: {}, gender: {}, chatId: {}.",
                name, gender, chatId);

        JClient client = new JClient();
        client.setName(name);
        client.setGender(gender);
        client.setChatId(chatId);

        return this.chatService.createOrUpdateClient(client);
    }

    /**
     * Return equipment types 'Json object.
     *
     * @return String
     */
    @GetMapping(value = "/equipment-type")
    @ResponseBody
    public String readEquipmentTypes() {

        log.info("Searching equipment types for Chat.");

        return this.chatService.readEquipmentTypes();
    }

    /**
     * Return equipment models 'Json object.
     *
     * @return String
     */
    @GetMapping(value = "/equipment-model/{equipmentTypeId}")
    @ResponseBody
    public String readEquipmentModels(@PathVariable("equipmentTypeId") Long equipmentTypeId) {

        log.info("Searching equipment models for Chat by equipment type id {}.", equipmentTypeId);

        JEquipmentType equipmentType = new JEquipmentType();
        equipmentType.setId(equipmentTypeId);

        return this.chatService.readEquipmentModels(equipmentType);
    }

    //--------------------------------------------------------------------------
    /**
     * Remove plus of text.
     *
     * @param text
     * @return String
     */
    private String removePlus(String text) {
        return (text != null && !text.isEmpty() && text.contains("+")) ? text.replace("+", " ") : text;
    }

}
