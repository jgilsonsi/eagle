package com.jjdev.eagle.api.services;

import com.jjdev.eagle.api.entities.JStatistic;
import java.util.List;

/**
 *
 * @author JGilson
 */
public interface IStatisticService {

    /**
     * Return list of amount of clients by month.
     *
     * @return List<JStatistic>
     */
    List<JStatistic> readAmountOfClientsByMonth();

    /**
     * Return list of amount of visits by month.
     *
     * @return List<JStatistic>
     */
    List<JStatistic> readAmountOfVisitsByMonth();

    /**
     * Return list of amount of orders by month.
     *
     * @return List<JStatistic>
     */
    List<JStatistic> readAmountOfOrdersByMonth();

}
