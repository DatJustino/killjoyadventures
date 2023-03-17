package com.killjoy.killjoyadventures.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @Column(length = 4)
    private String customerId;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    Set<Reservation> reservations = new HashSet<>();
}
