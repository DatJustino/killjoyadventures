package com.killjoy.killjoyadventures.repositories;

import com.killjoy.killjoyadventures.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {
}
