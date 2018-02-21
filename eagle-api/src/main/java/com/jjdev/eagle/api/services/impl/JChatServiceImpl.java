package com.jjdev.eagle.api.services.impl;

import com.jjdev.eagle.api.json.button.JButton;
import com.jjdev.eagle.api.json.button.JChatButton;
import com.jjdev.eagle.api.repositories.IEquipmentTypeRepository;
import com.jjdev.eagle.api.services.IChatService;
import com.jjdev.eagle.api.utils.JJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JGilson
 */
@Service
public class JChatServiceImpl implements IChatService {

    @Autowired
    private IEquipmentTypeRepository equipmentTypeRepository;

    @Override
    public String readEquipmentTypeButtons() {

        JChatButton chatButton = new JChatButton();
        this.equipmentTypeRepository.findAll().stream().map(equipmentType -> {
            JButton button = new JButton();
            button.setType("show_block");
            button.setTitle(equipmentType.getName());
            button.getBlockNames().add(equipmentType.getName());
            return button;
        }).forEachOrdered(button -> {
            chatButton.getMessages().get(0).getAttachment()
                    .getPayload().getButtons().add(button);
        });

        return JJsonUtils.objectToJson(chatButton);
    }

}
