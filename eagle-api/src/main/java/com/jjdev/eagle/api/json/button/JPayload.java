package com.jjdev.eagle.api.json.button;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JGilson
 */
public class JPayload {

    private String text;
    @JsonProperty("template_type")
    private String templateType;
    private List<JButton> buttons;

    public JPayload() {
        this.templateType = "button";
        this.text = "Hello!";
        this.buttons = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public List<JButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<JButton> buttons) {
        this.buttons = buttons;
    }

}
