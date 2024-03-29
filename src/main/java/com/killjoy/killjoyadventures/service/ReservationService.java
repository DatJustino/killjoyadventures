package com.killjoy.killjoyadventures.service;

import com.killjoy.killjoyadventures.exception.ResourceNotFoundException;
import com.killjoy.killjoyadventures.model.*;
import com.killjoy.killjoyadventures.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

  @Autowired
  private final ReservationRepo reservationRepo;

  public ReservationService(ReservationRepo reservationRepo) {
    this.reservationRepo = reservationRepo;
  }

  public Reservation getReservationById(String id) {
    return reservationRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Reservation", id));
  }

  public Reservation createReservation(Reservation reservation) {
    return reservationRepo.save(reservation);
  }

  public Reservation updateReservation(String id, Reservation reservation) {
    Reservation existingReservation = reservationRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Reservation", id));
    existingReservation.setTimeslot(reservation.getTimeslot());
    existingReservation.setCustomer(reservation.getCustomer());
    existingReservation.setActivity(reservation.getActivity());
    return reservationRepo.save(existingReservation);
  }

  public void deleteReservation(String id) {
    if (!reservationRepo.existsById(id)) {
      throw new ResourceNotFoundException("Reservation", id);
    }
    reservationRepo.deleteById(id);
  }
}
