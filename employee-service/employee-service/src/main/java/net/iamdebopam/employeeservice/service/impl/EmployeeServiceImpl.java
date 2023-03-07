package net.iamdebopam.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.iamdebopam.employeeservice.Mapper.UserMapper;
import net.iamdebopam.employeeservice.dto.EmployeeDto;
import net.iamdebopam.employeeservice.entity.Employee;
import net.iamdebopam.employeeservice.repository.EmployeeRepository;
import net.iamdebopam.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee= UserMapper.MAPPER.mapToEmployee(employeeDto);
        Employee saveEmployee=employeeRepository.save(employee);
        EmployeeDto saveEmployeeDto= UserMapper.MAPPER.mapToEmployeeDto(saveEmployee);
        return saveEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Optional<Employee> getEmployee=employeeRepository.findById(id);
        Employee employee=getEmployee.get();
        EmployeeDto employeeDto=modelMapper.map(employee,EmployeeDto.class);
        return employeeDto;
    }
}
