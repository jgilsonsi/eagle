package com.jjdev.eagle.api.json.quickreply;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JGilson
 */
public class JQuickReplyChat {

    private List<JQuickReplyMessage> messages;

    public JQuickReplyChat() {
        this.messages = new ArrayList<>();
        this.messages.add(new JQuickReplyMessage());
    }

    public List<JQuickReplyMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<JQuickReplyMessage> messages) {
        this.messages = messages;
    }

}
