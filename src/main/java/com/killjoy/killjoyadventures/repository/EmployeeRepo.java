package com.killjoy.killjoyadventures.repository;

import com.killjoy.killjoyadventures.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {

}
