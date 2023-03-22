package com.killjoy.killjoyadventures2;

import com.killjoy.killjoyadventures.model.Activity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ActivityTest {

  @Test
  void createActivity() {

    /*Using the BDD Approach we will be using Given-When and then.
     from wikipedia:  Given [initial context], when [event occurs], then [ensure some outcomes] .
     The given is the initialization of the paramenters, when is the event that is usually posting to a DB, and Then
     ensures that we have data-integrity.
     */


    // Given
    int activityId = 1;
    String activityName = "Sample Activity";

    // When
    Activity activity = new Activity();
    activity.setActivityId(activityId);
    activity.setActivityName(activityName);

    // Then
    assertThat(activity.getActivityId()).isEqualTo(activityId);
    assertThat(activity.getActivityName()).isEqualTo(activityName);
  }
}