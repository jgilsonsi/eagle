package com.jjdev.eagle.api.services.impl;

import com.jjdev.eagle.api.entities.JStatistic;
import com.jjdev.eagle.api.repositories.IStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jjdev.eagle.api.services.IStatisticService;
import java.util.List;

/**
 *
 * @author JGilson
 */
@Service
public class JStatisticServiceImpl implements IStatisticService {

    @Autowired
    private IStatisticRepository statisticRepository;

    @Override
    public List<JStatistic> readNumberOfClientsByMonth() {
        return this.statisticRepository.findNumberOfClientsByMonth();
    }

    @Override
    public List<JStatistic> readNumberOfVisitsByMonth() {
        return this.statisticRepository.findNumberOfVisitsByMonth();
    }

    @Override
    public List<JStatistic> readNumberOfOrdersByMonth() {
        return this.statisticRepository.findNumberOfOrdersByMonth();
    }

    @Override
    public List<JStatistic> readNumberOfOrdersByEquipmentType() {
        return this.statisticRepository.findNumberOfOrdersByEquipmentType();
    }

    @Override
    public JStatistic readNumberOfVisits() {
        return this.statisticRepository.findNumberOfVisits();
    }

    @Override
    public JStatistic readNumberOfClients() {
        return this.statisticRepository.findNumberOfClients();
    }

    @Override
    public JStatistic readNumberOfOrders() {
        return this.statisticRepository.findNumberOfOrders();
    }

}
