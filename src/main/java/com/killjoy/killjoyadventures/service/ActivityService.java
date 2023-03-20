package com.killjoy.killjoyadventures.service;

import com.killjoy.killjoyadventures.exception.ResourceNotFoundException;
import com.killjoy.killjoyadventures.model.Activity;
import com.killjoy.killjoyadventures.repository.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
  @Autowired
  private final ActivityRepo activityRepo;

  public ActivityService(ActivityRepo activityRepo) {
    this.activityRepo = activityRepo;
  }
  public List<Activity> getAll() {
    return activityRepo.findAll();
  }
  public Activity getActivityById(String id) {
    return activityRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Activity", id));
  }
  public Activity createActivity(Activity activity) {
    return activityRepo.save(activity);
  }
  public Activity updateActivity(String id, Activity activity) {
    Optional<Activity> existingActivity = activityRepo.findById(id);
    if (existingActivity.isPresent()) {
      activity.setActivityId(Integer.parseInt(id));
      return activityRepo.save(activity);
    } else {
      throw new ResourceNotFoundException("Activity", id);
    }
  }
  public void deleteActivity(String id) {
    if (activityRepo.existsById(id)) {
      activityRepo.deleteById(id);
    } else {
      throw new ResourceNotFoundException("Activity", id);
    }
  }
}