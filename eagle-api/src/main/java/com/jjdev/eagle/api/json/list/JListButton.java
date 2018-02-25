package com.jjdev.eagle.api.json.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JGilson
 */
public class JListButton {

    private String title;
    private String type;
    @JsonProperty("block_names")
    private List<String> blockNames;
    @JsonProperty("set_attributes")
    private JListSetAttributes setAttributes;

    public JListButton() {
        this.title = "Escolher";
        this.type = "show_block";
        this.blockNames = new ArrayList<>();
        this.blockNames.add("Booking confirm");
        this.setAttributes = new JListSetAttributes();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getBlockNames() {
        return blockNames;
    }

    public void setBlockNames(List<String> blockNames) {
        this.blockNames = blockNames;
    }

    public JListSetAttributes getSetAttributes() {
        return setAttributes;
    }

    public void setSetAttributes(JListSetAttributes setAttributes) {
        this.setAttributes = setAttributes;
    }

}
