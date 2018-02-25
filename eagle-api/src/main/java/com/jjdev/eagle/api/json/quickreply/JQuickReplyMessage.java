package com.jjdev.eagle.api.json.quickreply;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JGilson
 */
public class JQuickReplyMessage {

    private String text;
    @JsonProperty("quick_replies")

    private List<JQuickReply> quickReplies;

    public JQuickReplyMessage() {
        this.quickReplies = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<JQuickReply> getQuickReplies() {
        return quickReplies;
    }

    public void setQuickReplies(List<JQuickReply> quickReplies) {
        this.quickReplies = quickReplies;
    }

}
