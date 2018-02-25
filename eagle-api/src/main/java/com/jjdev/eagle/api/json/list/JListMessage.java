package com.jjdev.eagle.api.json.list;

/**
 *
 * @author JGilson
 */
public class JListMessage {

    private JListAttachment attachment;

    public JListMessage() {
        this.attachment = new JListAttachment();
    }

    public JListAttachment getAttachment() {
        return attachment;
    }

    public void setAttachment(JListAttachment attachment) {
        this.attachment = attachment;
    }

}
