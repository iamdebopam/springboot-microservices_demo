package net.iamdebopam.employeeservice.controller;

import lombok.AllArgsConstructor;
import net.iamdebopam.employeeservice.dto.EmployeeDto;
import net.iamdebopam.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployeeDto=employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployeeDto, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId){
        EmployeeDto getEmployeeDto=employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(getEmployeeDto,HttpStatus.OK);
    }
}
