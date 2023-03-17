package com.killjoy.killjoyadventures.repositories;

import com.killjoy.killjoyadventures.model.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TimeslotRepo extends JpaRepository<Timeslot, String> {
}
