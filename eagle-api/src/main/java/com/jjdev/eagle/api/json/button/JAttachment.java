package com.jjdev.eagle.api.json.button;

/**
 *
 * @author JGilson
 */
public class JAttachment {

    private String type;
    private JPayload payload;

    public JAttachment() {
        this.type = "template";
        this.payload = new JPayload();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JPayload getPayload() {
        return payload;
    }

    public void setPayload(JPayload payload) {
        this.payload = payload;
    }

}
