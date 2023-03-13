package com.killjoy.killjoyadventures.repositories;

import com.killjoy.killjoyadventures.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, String> {

}
