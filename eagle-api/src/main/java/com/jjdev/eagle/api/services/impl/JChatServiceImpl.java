package com.jjdev.eagle.api.services.impl;

import com.jjdev.eagle.api.json.quickreply.JQuickReplyChat;
import com.jjdev.eagle.api.json.quickreply.JQuickReply;
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
    public String readEquipmentTypes() {

        JQuickReplyChat quickReplyChat = new JQuickReplyChat();
        quickReplyChat.getMessages().get(0).setText("Escolha uma das opções:");
        this.equipmentTypeRepository.findAll().stream().map(equipmentType -> {
            JQuickReply quickReply = new JQuickReply();
            quickReply.setTitle(equipmentType.getName());
            quickReply.getQuickReplyAttributes().setEquipmentTypeId(equipmentType.getId());
            quickReply.getQuickReplyAttributes().setEquipmentTypeName(equipmentType.getName());
            return quickReply;
        }).forEachOrdered(quickReply -> {
            quickReplyChat.getMessages().get(0).getQuickReplies().add(quickReply);
        });

        return JJsonUtils.objectToJson(quickReplyChat);
    }

}
