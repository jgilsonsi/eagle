package com.jjdev.eagle.api.repositories;

import com.jjdev.eagle.api.entities.JStatistic;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JGilson
 */
public interface IStatisticRepository extends JpaRepository<JStatistic, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT MONTH(created) AS item, count(*) AS value "
            + "FROM client WHERE YEAR(created) = YEAR(current_date()) "
            + "GROUP BY MONTH(created) ORDER BY item",
            nativeQuery = true
    )
    List<JStatistic> findAmountOfClientsByMonth();

    @Transactional(readOnly = true)
    @Query(value = "SELECT MONTH(last_visit) AS item, count(*) AS value "
            + "FROM client WHERE YEAR(last_visit) = YEAR(current_date()) "
            + "GROUP BY MONTH(last_visit) ORDER BY item",
            nativeQuery = true
    )
    List<JStatistic> findAmountOfVisitsByMonth();

    @Transactional(readOnly = true)
    @Query(value = "SELECT MONTH(created) AS item, count(*) AS value "
            + "FROM _order WHERE YEAR(created) = YEAR(current_date()) "
            + "GROUP BY MONTH(created) ORDER BY item",
            nativeQuery = true
    )
    List<JStatistic> findAmountOfOrdersByMonth();

}
