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
    public List<JStatistic> readAmountOfClientsByMonth() {
        return this.statisticRepository.findAmountOfClientsByMonth();
    }

    @Override
    public List<JStatistic> readAmountOfVisitsByMonth() {
        return this.statisticRepository.findAmountOfVisitsByMonth();
    }

    @Override
    public List<JStatistic> readAmountOfOrdersByMonth() {
        return this.statisticRepository.findAmountOfOrdersByMonth();
    }

    @Override
    public List<JStatistic> readAmountOfOrdersByEquipmentType() {
        return this.statisticRepository.findAmountOfOrdersByEquipmentType();
    }

}
