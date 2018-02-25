package com.jjdev.eagle.api.controllers;

import com.jjdev.eagle.api.services.IChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    private static final Logger log = LoggerFactory.getLogger(JChatController.class);

    @Autowired
    private IChatService chatService;

    public JChatController() {
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

}
