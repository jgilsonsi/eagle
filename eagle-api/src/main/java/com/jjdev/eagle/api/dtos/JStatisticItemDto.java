package com.jjdev.eagle.api.dtos;

/**
 *
 * @author JGilson
 */
public class JStatisticItemDto {

    private String name;

    private Long value;

    public JStatisticItemDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "JStatisticItemDto{" + "name=" + name + ", value=" + value + '}';
    }

}
