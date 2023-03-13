package com.killjoy.killjoyadventures.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ActRes { //intermediate table
    @Id
    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "activityId") //sidste SKAL hedde det PK er for activity
    //første kommer til at hedde det man skriver her i databasen
    private Activity activity;

    @Id
    @ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservationId")
    private Reservation reservation;
}
