package net.iamdebopam.departmentservice.service.impl;

import net.iamdebopam.departmentservice.Mapper.UserMapper;
import net.iamdebopam.departmentservice.dto.DepartmentDto;
import net.iamdebopam.departmentservice.entity.Department;
import net.iamdebopam.departmentservice.repository.DepartmentRepository;
import net.iamdebopam.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert department dto to department jpa entity with ModelMapper
        Department department=modelMapper.map(departmentDto,Department.class);
        Department savedDepartment=departmentRepository.save(department);
        DepartmentDto savedDepartmentDto=modelMapper.map(savedDepartment,DepartmentDto.class);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department=departmentRepository.findByDepartmentCode(departmentCode);
        //convert department jpa to department dto using MapStruct
        DepartmentDto getDepartmentDto= UserMapper.MAPPER.mapToDepartmentDto(department);
        return getDepartmentDto;
    }


}
