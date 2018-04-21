package com.jjdev.eagle.api.repositories;

import com.jjdev.eagle.api.entities.JStatistic;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JGilson
 */
public interface IStatisticRepository extends JpaRepository<JStatistic, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT MONTH(created) AS name, COUNT(*) AS value "
            + "FROM client WHERE YEAR(created) = YEAR(current_date()) "
            + "GROUP BY MONTH(created) ORDER BY name",
            nativeQuery = true
    )
    List<JStatistic> findNumberOfClientsByMonth();

    @Transactional(readOnly = true)
    @Query(value = "SELECT MONTH(last_visit) AS name, COUNT(*) AS value "
            + "FROM client WHERE YEAR(last_visit) = YEAR(current_date()) "
            + "GROUP BY MONTH(last_visit) ORDER BY name",
            nativeQuery = true
    )
    List<JStatistic> findNumberOfVisitsByMonth();

    @Transactional(readOnly = true)
    @Query(value = "SELECT MONTH(created) AS name, COUNT(*) AS value "
            + "FROM _order WHERE YEAR(created) = YEAR(current_date()) "
            + "GROUP BY MONTH(created) ORDER BY name",
            nativeQuery = true
    )
    List<JStatistic> findNumberOfOrdersByMonth();

    @Transactional(readOnly = true)
    @Query(value = "SELECT et._name AS name, COUNT(*) AS value "
            + "FROM _order o LEFT JOIN equipment_model em ON o.equipment_model_id = em.id "
            + "LEFT JOIN equipment_type et ON em.equipment_type_id = et.id "
            + "WHERE MONTH(o.created) = MONTH(current_date()) "
            + "GROUP BY et.id ORDER BY et._name",
            nativeQuery = true
    )
    List<JStatistic> findNumberOfOrdersByEquipmentType();

    @Transactional(readOnly = true)
    @Query(value = "SELECT 'visits' AS name, COUNT(*) AS value FROM client "
            + "WHERE DATE(last_visit) = current_date()",
            nativeQuery = true
    )
    JStatistic findNumberOfVisits();

    @Transactional(readOnly = true)
    @Query(value = "SELECT 'clients' AS name, COUNT(*) AS value FROM client "
            + "WHERE DATE(created) = current_date();",
            nativeQuery = true
    )
    JStatistic findNumberOfClients();

    @Transactional(readOnly = true)
    @Query(value = "SELECT 'orders' AS name, COUNT(*) AS value FROM _order "
            + "WHERE DATE(created) = current_date()",
            nativeQuery = true
    )
    JStatistic findNumberOfOrders();

}
