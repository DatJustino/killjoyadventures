package com.killjoy.killjoyadventures.repositories;

import com.killjoy.killjoyadventures.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation, String> {
}
