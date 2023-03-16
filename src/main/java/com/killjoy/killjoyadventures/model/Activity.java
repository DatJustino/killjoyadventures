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
public class Activity {
    @Id
    @Column(length = 4)
    private String activityId;

    @OneToMany(mappedBy = "activity")
    @JsonBackReference
    private Set<Timeslot> timeslots = new HashSet<>();
}
