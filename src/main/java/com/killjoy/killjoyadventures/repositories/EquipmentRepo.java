package com.killjoy.killjoyadventures.repositories;

import com.killjoy.killjoyadventures.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepo extends JpaRepository<Equipment, String> {
}
