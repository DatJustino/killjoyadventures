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
public class Customer {

  @Id
  @Column(length = 4)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer customerId;

  @Column(nullable = false)
  private String customerName;
  //@NotNull paused while testing.
  @Column(nullable = false, unique = true)
  private String customerEmail;

  @OneToMany(mappedBy = "customer")
  @JsonBackReference
  Set<Reservation> reservations = new HashSet<>();
}
