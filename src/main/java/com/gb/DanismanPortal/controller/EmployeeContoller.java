package com.gb.DanismanPortal.controller;

import com.gb.DanismanPortal.constants.Constants;
import com.gb.DanismanPortal.request.Employee.EmployeeAddRequest;
import com.gb.DanismanPortal.request.Employee.EmployeeUpdateRequest;
import com.gb.DanismanPortal.response.EmployeeResponse;
import com.gb.DanismanPortal.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeContoller {
    private final EmployeeService employeeService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<EmployeeResponse> employeeResponses = employeeService.listAll();
        return new ResponseEntity<>(employeeResponses, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody EmployeeAddRequest employeeAddRequest){
        employeeService.save(employeeAddRequest);
        return new ResponseEntity<>(Constants.SAVED_SUCCES_STATUS, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody EmployeeUpdateRequest employeeUpdateRequest){
        employeeService.update(employeeUpdateRequest);
        return new ResponseEntity<>(Constants.UPDATED_SUCCES_STATUS, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int employeeId){
        employeeService.delete(employeeId);
        return new ResponseEntity<>(Constants.DELETED_SUCCESS_STATUS, HttpStatus.OK);
    }

}
