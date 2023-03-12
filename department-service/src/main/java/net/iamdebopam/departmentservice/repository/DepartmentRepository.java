package net.iamdebopam.departmentservice.repository;

import net.iamdebopam.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentCode(String code);
}
