package com.killjoy.killjoyadventures.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @SequenceGenerator(name = "reservationGen",
        initialValue = 40, allocationSize = 4)
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "reservationGen")    @Column(length = 4)
    private Integer reservationId;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "timeslotId", referencedColumnName = "timeslotId")
    private Timeslot timeslot;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "activityId", referencedColumnName = "activityId", nullable = false) //res skal have act
    private Activity activity;

}
