package com.jjdev.eagle.api.repositories;

import com.jjdev.eagle.api.entities.JEquipmentModel;
import com.jjdev.eagle.api.entities.JEquipmentType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JGilson
 */
public interface IEquipmentModelRepository extends JpaRepository<JEquipmentModel, Long> {

    @Transactional(readOnly = true)
    List<JEquipmentModel> findByEquipmentType(JEquipmentType equipmentType);

}
