package com.jjdev.eagle.api.dtos;

import java.util.List;

/**
 *
 * @author JGilson
 */
public class JStatisticDto {

    private List<JStatisticItemDto> amountOfClientsByMonth;

    private List<JStatisticItemDto> amountOfOrdersByMonth;

    private List<JStatisticItemDto> amountOfVisitsByMonth;

    private List<JStatisticItemDto> amountOfOrdersByEquipmentType;

    public JStatisticDto() {
    }

    public List<JStatisticItemDto> getAmountOfClientsByMonth() {
        return amountOfClientsByMonth;
    }

    public void setAmountOfClientsByMonth(List<JStatisticItemDto> amountOfClientsByMonth) {
        this.amountOfClientsByMonth = amountOfClientsByMonth;
    }

    public List<JStatisticItemDto> getAmountOfOrdersByMonth() {
        return amountOfOrdersByMonth;
    }

    public void setAmountOfOrdersByMonth(List<JStatisticItemDto> amountOfOrdersByMonth) {
        this.amountOfOrdersByMonth = amountOfOrdersByMonth;
    }

    public List<JStatisticItemDto> getAmountOfVisitsByMonth() {
        return amountOfVisitsByMonth;
    }

    public void setAmountOfVisitsByMonth(List<JStatisticItemDto> amountOfVisitsByMonth) {
        this.amountOfVisitsByMonth = amountOfVisitsByMonth;
    }

    public List<JStatisticItemDto> getAmountOfOrdersByEquipmentType() {
        return amountOfOrdersByEquipmentType;
    }

    public void setAmountOfOrdersByEquipmentType(List<JStatisticItemDto> amountOfOrdersByEquipmentType) {
        this.amountOfOrdersByEquipmentType = amountOfOrdersByEquipmentType;
    }

    @Override
    public String toString() {
        return "JStatisticDto{" + "amountOfClientsByMonth=" + amountOfClientsByMonth
                + ", amountOfOrdersByMonth=" + amountOfOrdersByMonth + ", amountOfVisitsByMonth="
                + amountOfVisitsByMonth + ", amountOfOrdersByEquipmentType=" + amountOfOrdersByEquipmentType + '}';
    }

}
