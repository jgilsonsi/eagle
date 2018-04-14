package com.jjdev.eagle.api.dtos;

/**
 *
 * @author JGilson
 */
public class JStatisticItemDto {

    private String item;

    private Long value;

    public JStatisticItemDto() {
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "JStatisticDto{" + "item=" + item + ", value=" + value + '}';
    }

}
