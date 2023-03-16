package com.killjoy.killjoyadventures.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Timeslot { //intermediate table

    @Id
    @Column(length = 4)
    private String timeslotId;

    @ManyToOne
    @JoinColumn(name = "activityId", referencedColumnName = "activityId") //sidste SKAL hedde det PK er for activity
    //første kommer til at hedde det man skriver her i databasen
    private Activity activity;

    @OneToMany(mappedBy = "timeslot")
    @JsonBackReference
    private Set<Reservation> reservations = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;
}
