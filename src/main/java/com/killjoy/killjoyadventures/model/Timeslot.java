package com.killjoy.killjoyadventures.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)

public class Timeslot {

    @Id
    @Column(length = 4)
    private Integer timeslotId;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "timeSlotStart")
    private LocalTime timeSlotStart;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "activityId", referencedColumnName = "activityId")
    private Activity activity;

    @NotNull
    @OneToMany(mappedBy = "timeslot", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Reservation> reservations = new HashSet<>();

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;
}