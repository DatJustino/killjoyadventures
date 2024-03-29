package com.killjoy.killjoyadventures.service;

import com.killjoy.killjoyadventures.exception.ResourceNotFoundException;
import com.killjoy.killjoyadventures.model.Timeslot;
import com.killjoy.killjoyadventures.repository.TimeslotRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class TimeslotService {

  private final TimeslotRepo timeslotRepo;

  @Autowired
  public TimeslotService(TimeslotRepo timeslotRepo) {
    this.timeslotRepo = timeslotRepo;
  }

  public List<Timeslot> getAllTimeslots() {
    return timeslotRepo.findAll();
  }

  public Timeslot getTimeSlotById(int id) {
    Optional<Timeslot> timeslot = timeslotRepo.findById(String.valueOf(id));
    if (timeslot.isPresent()) {
      return timeslot.get();
    } else {
      throw new ResourceNotFoundException("Timeslot", String.valueOf(id));
    }
  }

  public Timeslot createTimeslot(Timeslot timeslot) {
    return timeslotRepo.save(timeslot);
  }

  public Timeslot updateTimeSlot(int id, Timeslot timeslot) {
    Optional<Timeslot> optionalTimeslot = timeslotRepo.findById(String.valueOf(id));
    if (optionalTimeslot.isPresent()) {
      Timeslot timeslot1 = optionalTimeslot.get();
      timeslot.setTimeSlotStart(timeslot.getTimeSlotStart());
      timeslot.setActivity(timeslot.getActivity());
      timeslot.setEmployee(timeslot.getEmployee());
      return timeslotRepo.save(timeslot);
    } else {
      throw new ResourceNotFoundException("Timeslot",String.valueOf(id));
    }
  }

  public void deleteTimeslot(int id) {
    Optional<Timeslot> timeslot = timeslotRepo.findById(String.valueOf(id));
    if (timeslot.isPresent()) {
      timeslotRepo.deleteById(String.valueOf(id));
    } else {
      throw new ResourceNotFoundException("Timeslot", String.valueOf(id));
    }
  }
}