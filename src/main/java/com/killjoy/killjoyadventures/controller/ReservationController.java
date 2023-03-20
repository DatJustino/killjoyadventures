package com.killjoy.killjoyadventures.controller;

import com.killjoy.killjoyadventures.model.Reservation;
import com.killjoy.killjoyadventures.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReservationController {
  @Autowired
  ReservationRepo reservationRepo;

  @GetMapping("/reservations")
  public List<Reservation> getReservations(){
    return reservationRepo.findAll();
  }
  @PostMapping("/reservation")
  @ResponseStatus(HttpStatus.CREATED)
  public Reservation addReservation(@RequestBody Reservation reservation){
    System.out.println(reservation);
    return reservationRepo.save(reservation);
  }
}
