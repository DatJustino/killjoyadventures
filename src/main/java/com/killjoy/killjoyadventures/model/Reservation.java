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

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "activityId", referencedColumnName = "activityId", nullable = false) //res skal have act
    private Activity activity;

}
