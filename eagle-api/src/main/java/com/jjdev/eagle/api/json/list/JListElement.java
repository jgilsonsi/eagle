package com.jjdev.eagle.api.json.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JGilson
 */
public class JListElement {

    private String title;    
    private String subtitle;
    @JsonProperty("image_url")
    private String imageUrl;
    private List<JListButton> buttons;

    public JListElement() {
        this.buttons = new ArrayList<>();
        this.buttons.add(new JListButton());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<JListButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<JListButton> buttons) {
        this.buttons = buttons;
    }

}
