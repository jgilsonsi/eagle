package com.jjdev.eagle.api.services;

import com.jjdev.eagle.api.entities.JStatistic;
import java.util.List;

/**
 *
 * @author JGilson
 */
public interface IStatisticService {

    /**
     * Returns the list with the number of clients per month in the current
     * year.
     *
     * @return List<JStatistic>
     */
    List<JStatistic> readNumberOfClientsByMonth();

    /**
     * Returns the list with the number of visits per month in the current year.
     *
     * @return List<JStatistic>
     */
    List<JStatistic> readNumberOfVisitsByMonth();

    /**
     * Returns the list with the number of orders per month in the current year.
     *
     * @return List<JStatistic>
     */
    List<JStatistic> readNumberOfOrdersByMonth();

    /**
     * Returns the list with the number of orders by Equipment type in the
     * current month.
     *
     * @return List<JStatistic>
     */
    List<JStatistic> readNumberOfOrdersByEquipmentType();

    /**
     * Returns the number of visits today
     *
     * @return JStatistic
     */
    JStatistic readNumberOfVisits();

    /**
     * Returns the number of clients today
     *
     * @return JStatistic
     */
    JStatistic readNumberOfClients();

    /**
     * Returns the number of orders today
     *
     * @return JStatistic
     */
    JStatistic readNumberOfOrders();

}
