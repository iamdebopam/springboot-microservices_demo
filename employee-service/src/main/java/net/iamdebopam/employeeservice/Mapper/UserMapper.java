package net.iamdebopam.employeeservice.Mapper;


import net.iamdebopam.employeeservice.dto.EmployeeDto;
import net.iamdebopam.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER= Mappers.getMapper(UserMapper.class);
    EmployeeDto mapToEmployeeDto(Employee employee);
    Employee mapToEmployee(EmployeeDto employeeDto);
}
