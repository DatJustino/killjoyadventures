package com.killjoy.killjoyadventures.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Employee {

    @SequenceGenerator(name = "employeeGen",
        initialValue = 30, allocationSize = 4)
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "employeeGen")
    @Column(length = 4)
    private Integer employeeId;
    @NotNull
    @Column(nullable = false)
    private String name;
    @NotNull
    @Column(nullable = false, unique = true)
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Timeslot> timeslots = new HashSet<>();

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addTimeslot(Timeslot timeslot) {
        timeslots.add(timeslot);
        timeslot.setEmployee(this);
    }

    public void removeTimeslot(Timeslot timeslot) {
        timeslots.remove(timeslot);
        timeslot.setEmployee(null);
    }
}