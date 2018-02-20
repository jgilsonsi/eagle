package com.jjdev.eagle.api.json;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JGilson
 */
public class JChatButton {

    private List<JMessage> messages;

    public JChatButton() {
        messages = new ArrayList<>();
        messages.add(new JMessage());
    }

    public List<JMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<JMessage> messages) {
        this.messages = messages;
    }

}
