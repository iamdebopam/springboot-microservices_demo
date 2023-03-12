package net.iamdebopam.employeeservice.repository;

import net.iamdebopam.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
