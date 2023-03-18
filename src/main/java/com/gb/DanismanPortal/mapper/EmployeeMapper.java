package com.gb.DanismanPortal.mapper;

import com.gb.DanismanPortal.entity.Employee;
import com.gb.DanismanPortal.response.EmployeeResponse;
import com.gb.DanismanPortal.request.Employee.EmployeeAddRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    List<EmployeeResponse> toEmployeeResponseList (List<Employee> employies);
    EmployeeResponse toEmployeeResponse (Employee employee);
    Employee toEmployee (EmployeeAddRequest employeeAddRequest);
}
