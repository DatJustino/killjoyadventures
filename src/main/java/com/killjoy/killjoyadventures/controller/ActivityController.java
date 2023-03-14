package com.killjoy.killjoyadventures.controller;

import com.killjoy.killjoyadventures.model.Activity;
import com.killjoy.killjoyadventures.repositories.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ActivityController {

    @Autowired
    ActivityRepo activityRepo;

    @GetMapping("/activity")
    public List<Activity> getActivity(){
        return activityRepo.findAll();
    }
}
