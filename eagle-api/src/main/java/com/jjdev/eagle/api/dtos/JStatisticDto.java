package com.jjdev.eagle.api.dtos;

import java.util.List;

/**
 *
 * @author JGilson
 */
public class JStatisticDto {

    private List<JStatisticItemDto> numberOfClientsByMonth;

    private List<JStatisticItemDto> numberOfOrdersByMonth;

    private List<JStatisticItemDto> numberOfVisitsByMonth;

    private List<JStatisticItemDto> numberOfOrdersByEquipmentType;

    private JStatisticItemDto numberOfVisits;

    private JStatisticItemDto numberOfClients;

    private JStatisticItemDto numberOfOrders;

    public JStatisticDto() {
    }

    public List<JStatisticItemDto> getNumberOfClientsByMonth() {
        return numberOfClientsByMonth;
    }

    public void setNumberOfClientsByMonth(List<JStatisticItemDto> numberOfClientsByMonth) {
        this.numberOfClientsByMonth = numberOfClientsByMonth;
    }

    public List<JStatisticItemDto> getNumberOfOrdersByMonth() {
        return numberOfOrdersByMonth;
    }

    public void setNumberOfOrdersByMonth(List<JStatisticItemDto> numberOfOrdersByMonth) {
        this.numberOfOrdersByMonth = numberOfOrdersByMonth;
    }

    public List<JStatisticItemDto> getNumberOfVisitsByMonth() {
        return numberOfVisitsByMonth;
    }

    public void setNumberOfVisitsByMonth(List<JStatisticItemDto> numberOfVisitsByMonth) {
        this.numberOfVisitsByMonth = numberOfVisitsByMonth;
    }

    public List<JStatisticItemDto> getNumberOfOrdersByEquipmentType() {
        return numberOfOrdersByEquipmentType;
    }

    public void setNumberOfOrdersByEquipmentType(List<JStatisticItemDto> numberOfOrdersByEquipmentType) {
        this.numberOfOrdersByEquipmentType = numberOfOrdersByEquipmentType;
    }

    public JStatisticItemDto getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(JStatisticItemDto numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    public JStatisticItemDto getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(JStatisticItemDto numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public JStatisticItemDto getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(JStatisticItemDto numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    @Override
    public String toString() {
        return "JStatisticDto{" + "numberOfClientsByMonth=" + numberOfClientsByMonth
                + ", numberOfOrdersByMonth=" + numberOfOrdersByMonth + ", numberOfVisitsByMonth="
                + numberOfVisitsByMonth + ", numberOfOrdersByEquipmentType="
                + numberOfOrdersByEquipmentType + ", numberOfVisits=" + numberOfVisits
                + ", numberOfClients=" + numberOfClients + ", numberOfOrders="
                + numberOfOrders + '}';
    }

}
