package com.jjdev.eagle.api.json;

/**
 *
 * @author JGilson
 */
public class JAttachment {

    private String type;
    private JPayload payload;

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
