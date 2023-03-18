package com.killjoy.killjoyadventures.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Timeslot { //intermediate table

    @Id
    @Column(length = 4)
    private String timeslotId;
    @JsonFormat(pattern="dd HH:mm")
    @Column(name = "timeSlotStart")
    private LocalDateTime timeSlotStart;
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
