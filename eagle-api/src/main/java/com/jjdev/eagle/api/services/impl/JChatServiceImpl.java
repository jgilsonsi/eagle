package com.jjdev.eagle.api.services.impl;

import com.jjdev.eagle.api.entities.JClient;
import com.jjdev.eagle.api.entities.JEquipmentModel;
import com.jjdev.eagle.api.entities.JEquipmentType;
import com.jjdev.eagle.api.json.list.JListChat;
import com.jjdev.eagle.api.json.list.JListElement;
import com.jjdev.eagle.api.json.quickreply.JQuickReplyChat;
import com.jjdev.eagle.api.json.quickreply.JQuickReply;
import com.jjdev.eagle.api.repositories.IClientRepository;
import com.jjdev.eagle.api.repositories.IEquipmentModelRepository;
import com.jjdev.eagle.api.repositories.IEquipmentTypeRepository;
import com.jjdev.eagle.api.services.IChatService;
import com.jjdev.eagle.api.utils.JJsonUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author JGilson
 */
@Service
public class JChatServiceImpl implements IChatService {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IEquipmentTypeRepository equipmentTypeRepository;

    @Autowired
    private IEquipmentModelRepository equipmentModelRepository;

    @Value("${image.url}")
    private String imageUrl;

    @Override
    public String createOrUpdateClient(JClient client) {

        JClient localClient = this.clientRepository.findByChatId(client.getChatId());
        if (localClient != null) {
            this.clientRepository.update(client.getName(), client.getGender(),
                    client.getLastVisit(), client.getChatId());

            return "{\"set_attributes\": {\"client_id\": \"" + localClient.getId() + "\"}, "
                    + "\"redirect_to_blocks\": [\"Client old\"]}";
        } else {
            localClient = this.clientRepository.save(client);

            if (localClient != null) {
                return "{\"set_attributes\": {\"client_id\": \"" + localClient.getId() + "\"}, "
                        + "\"redirect_to_blocks\": [\"Client new\"]}";
            }
        }
        return "{\"redirect_to_blocks\": [\"Client new\"]}";
    }

    @Override
    public String readEquipmentTypes() {

        JQuickReplyChat quickReplyChat = new JQuickReplyChat();
        quickReplyChat.getMessages().get(0).setText("Escolha uma das opções:");

        List<JEquipmentType> equipmentTypes = this.equipmentTypeRepository.findAll();

        if (equipmentTypes.isEmpty()) {
            return "{\"redirect_to_blocks\": [\"Equipment empty\"]}";
        }

        equipmentTypes.stream().map(equipmentType -> {
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

    @Override
    public String readEquipmentModels(JEquipmentType equipmentType) {

        JListChat listChat = new JListChat();

        List<JEquipmentModel> equipmentModels = this.equipmentModelRepository
                .findByEquipmentType(equipmentType);

        if (equipmentModels.isEmpty()) {
            return "{\"redirect_to_blocks\": [\"Model empty\"]}";
        }

        equipmentModels.stream().map(equipmentModel -> {
            JListElement listElement = new JListElement();
            listElement.setTitle(equipmentModel.getId() + " - "
                    + equipmentModel.getName());
            listElement.setSubtitle(equipmentModel.getDescription());
            listElement.setImageUrl(imageUrl + "/" + equipmentModel.getId());
            listElement.getButtons().get(0).getSetAttributes()
                    .setEquipmentModelId(equipmentModel.getId());
            listElement.getButtons().get(0).getSetAttributes()
                    .setEquipmentModelName(equipmentModel.getName());
            listElement.getButtons().get(0).getSetAttributes()
                    .setEquipmentModelRate(equipmentModel.getRate());

            return listElement;
        }).forEachOrdered(listElement -> {
            listChat.getMessages().get(0).getAttachment().getPayload()
                    .getElements().add(listElement);
        });

        return JJsonUtils.objectToJson(listChat);
    }

}
