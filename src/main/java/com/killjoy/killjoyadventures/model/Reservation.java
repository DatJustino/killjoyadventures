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
public class Reservation {
    @Id
    @Column(length = 4)
    private String reservationId;

    @ManyToOne
    @JoinColumn(name = "timeslotId", referencedColumnName = "timeslotId")
    private Timeslot timeslot;
}
