package com.jjdev.eagle.api.json.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JGilson
 */
public class JListPayload {

    @JsonProperty("template_type")
    private String templateType;
    @JsonProperty("top_element_style")
    private String topElementStyle;
    private List<JListElement> elements;

    public JListPayload() {
        this.templateType = "list";
        this.topElementStyle = "compact";
        this.elements = new ArrayList<>();
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getTopElementStyle() {
        return topElementStyle;
    }

    public void setTopElementStyle(String topElementStyle) {
        this.topElementStyle = topElementStyle;
    }

    public List<JListElement> getElements() {
        return elements;
    }

    public void setElements(List<JListElement> elements) {
        this.elements = elements;
    }

}
