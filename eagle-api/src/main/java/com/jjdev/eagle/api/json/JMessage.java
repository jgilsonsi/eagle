package com.jjdev.eagle.api.json;

/**
 *
 * @author JGilson
 */
public class JMessage {

    private JAttachment attachment;

    public JMessage() {
        attachment = new JAttachment();
    }

    public JAttachment getAttachment() {
        return attachment;
    }

    public void setAttachment(JAttachment attachment) {
        this.attachment = attachment;
    }

}
