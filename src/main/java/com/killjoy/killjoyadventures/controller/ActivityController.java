package com.killjoy.killjoyadventures.controller;

import com.killjoy.killjoyadventures.model.Activity;
import com.killjoy.killjoyadventures.model.Timeslot;
import com.killjoy.killjoyadventures.repositories.ActivityRepo;
import com.killjoy.killjoyadventures.repositories.TimeslotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@CrossOrigin
public class ActivityController {

    @Autowired
    ActivityRepo activityRepo;
    @Autowired
    TimeslotRepo timeslotRepo;


    @GetMapping("/activity")
    public List<Activity> getActivity(){
        return activityRepo.findAll();
    }
    @GetMapping("/activitytime")
    public List<Timeslot> getActivityTime(){
        return timeslotRepo.findAll();
    }

    @PostMapping("/saveactivity")
    @ResponseStatus(HttpStatus.CREATED)
    public Activity postActivity(@RequestBody Activity activity) {
        System.out.println(activity);
        return activityRepo.save(activity);
    }
}
