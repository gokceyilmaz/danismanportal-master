package com.gb.DanismanPortal.service;

import com.gb.DanismanPortal.response.EmployeeResponse;
import com.gb.DanismanPortal.request.Employee.EmployeeAddRequest;
import com.gb.DanismanPortal.request.Employee.EmployeeUpdateRequest;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> listAll();
    EmployeeResponse save(EmployeeAddRequest employeeAddRequest);
    EmployeeResponse update(EmployeeUpdateRequest employeeUpdateRequest);
    void delete(Integer id);

}
