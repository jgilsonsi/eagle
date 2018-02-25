package com.jjdev.eagle.api.json.list;

/**
 *
 * @author JGilson
 */
public class JListAttachment {

    private String type;
    private JListPayload payload;

    public JListAttachment() {
        this.type = "template";
        this.payload = new JListPayload();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JListPayload getPayload() {
        return payload;
    }

    public void setPayload(JListPayload payload) {
        this.payload = payload;
    }

}
