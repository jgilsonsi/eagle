package com.jjdev.eagle.api.json.quickreply;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author JGilson
 */
public class JQuickReply {

    private String title;

    @JsonProperty("set_attributes")
    private JQuickReplyAttributes quickReplyAttributes;

    public JQuickReply() {
        this.quickReplyAttributes = new JQuickReplyAttributes();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JQuickReplyAttributes getQuickReplyAttributes() {
        return quickReplyAttributes;
    }

    public void setQuickReplyAttributes(JQuickReplyAttributes quickReplyAttributes) {
        this.quickReplyAttributes = quickReplyAttributes;
    }

}
