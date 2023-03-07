package net.iamdebopam.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.iamdebopam.employeeservice.Mapper.UserMapper;
import net.iamdebopam.employeeservice.dto.APIResponseDto;
import net.iamdebopam.employeeservice.dto.DepartmentDto;
import net.iamdebopam.employeeservice.dto.EmployeeDto;
import net.iamdebopam.employeeservice.entity.Employee;
import net.iamdebopam.employeeservice.repository.EmployeeRepository;
import net.iamdebopam.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee= UserMapper.MAPPER.mapToEmployee(employeeDto);
        Employee saveEmployee=employeeRepository.save(employee);
        EmployeeDto saveEmployeeDto= UserMapper.MAPPER.mapToEmployeeDto(saveEmployee);
        return saveEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Optional<Employee> getEmployee=employeeRepository.findById(id);
        Employee employee=getEmployee.get();

        //RestAPI call for DepartmentCode RESTTemplate
        ResponseEntity<DepartmentDto> responseEntity= restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
                DepartmentDto.class);
        DepartmentDto departmentDto=responseEntity.getBody();


        EmployeeDto employeeDto=modelMapper.map(employee,EmployeeDto.class);

        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
