package com.killjoy.killjoyadventures.repository;

import com.killjoy.killjoyadventures.model.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeslotRepo extends JpaRepository<Timeslot, String> {
}
