package net.iamdebopam.departmentservice.Mapper;


import net.iamdebopam.departmentservice.dto.DepartmentDto;
import net.iamdebopam.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER= Mappers.getMapper(UserMapper.class);
    DepartmentDto mapToDepartmentDto(Department department);
    Department mapToDepartment(DepartmentDto departmentDto);
}
