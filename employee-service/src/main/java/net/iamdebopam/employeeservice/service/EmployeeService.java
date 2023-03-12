package net.iamdebopam.employeeservice.service;

import net.iamdebopam.employeeservice.dto.APIResponseDto;
import net.iamdebopam.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);
}
