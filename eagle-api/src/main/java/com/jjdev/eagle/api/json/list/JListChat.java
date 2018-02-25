package com.jjdev.eagle.api.json.list;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JGilson
 */
public class JListChat {

    private List<JListMessage> messages;

    public JListChat() {
        this.messages = new ArrayList<>();
        this.messages.add(new JListMessage());
    }

    public List<JListMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<JListMessage> messages) {
        this.messages = messages;
    }

}
