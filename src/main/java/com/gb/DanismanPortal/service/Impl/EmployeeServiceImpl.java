package com.gb.DanismanPortal.service.Impl;

import com.gb.DanismanPortal.entity.Employee;
import com.gb.DanismanPortal.exception.ObjectNotFoundException;
import com.gb.DanismanPortal.mapper.EmployeeMapper;
import com.gb.DanismanPortal.repository.EmployeeRepository;
import com.gb.DanismanPortal.request.Employee.EmployeeAddRequest;
import com.gb.DanismanPortal.request.Employee.EmployeeUpdateRequest;
import com.gb.DanismanPortal.response.EmployeeResponse;
import com.gb.DanismanPortal.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponse> listAll(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> employeeResponses = employeeMapper.toEmployeeResponseList(employees);
        return employeeResponses;
    }

    @Override
    public EmployeeResponse save(EmployeeAddRequest employeeAddRequest) {
        Employee employee = employeeMapper.toEmployee(employeeAddRequest);
        Employee saved = employeeRepository.save(employee);
        return employeeMapper.toEmployeeResponse(saved);
    }

    @Override
    public EmployeeResponse update (EmployeeUpdateRequest employeeUpdateRequest){
        Optional<Employee> employee = employeeRepository.findById(employeeUpdateRequest.getId());
        if(employee.isPresent()){
            BeanUtils.copyProperties(employeeUpdateRequest, employee.get());
            Employee savedEmployee = employeeRepository.save(employee.get());
            return employeeMapper.toEmployeeResponse(savedEmployee);
        }
        else{
            throw new ObjectNotFoundException("Employee Not Found!");
        }
    }

    @Override
    public void delete(Integer id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            employee.get().setEndTime(LocalDate.now());
            employeeRepository.save(employee.get());
        }
    }
}
