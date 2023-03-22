package com.killjoy.killjoyadventures.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This line configures the ID to be auto-generated
    @Column(length = 4)
    private Integer activityId;
    @NotNull
    @Column(nullable = false, unique = true)
    private String activityName;

    @OneToMany(mappedBy = "activity")
    @JsonBackReference
    private Set<Timeslot> timeslots = new HashSet<>();
}
