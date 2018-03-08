package com.jjdev.eagle.api.controllers;

import com.jjdev.eagle.api.entities.JClient;
import com.jjdev.eagle.api.entities.JEquipmentType;
import com.jjdev.eagle.api.services.IChatService;
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

    private static final Logger log = LoggerFactory.getLogger(JChatController.class);

    public JChatController() {
    }

    /**
     * Create or update client if exists.
     *
     * @param name
     * @param gender
     * @param chatId
     * @return String
     */
    @PostMapping(value = "/client/{name}/{gender}/{chatId}")
    @ResponseBody
    public String createOrUpdateClient(@PathVariable("name") String name,
            @PathVariable("gender") String gender, @PathVariable("chatId") String chatId) {

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

}
