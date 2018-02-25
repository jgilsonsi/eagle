package com.jjdev.eagle.api.json.list;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JGilson
 */
public class JListElement {

    private String title;
    private String subtitle;
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

    public List<JListButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<JListButton> buttons) {
        this.buttons = buttons;
    }

}
