package com.killjoy.killjoyadventures.repository;

import com.killjoy.killjoyadventures.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
}
