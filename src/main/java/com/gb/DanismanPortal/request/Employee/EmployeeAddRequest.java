package com.gb.DanismanPortal.request.Employee;

import com.gb.DanismanPortal.entity.Address;
import com.gb.DanismanPortal.entity.Company;
import lombok.Data;
import java.time.LocalDate;

@Data
public class EmployeeAddRequest {
    private String name;
    private String surname;
    private int age;
    private String sector;
    private String coverLetter;
    private String description;
    private double salary;
    private String phoneNumber;
    private String email;
    private String password;
    private String linkedinUsername;
    private String companyEmail;
    private LocalDate createTime;
    private LocalDate endTime;
    private String company;
    private String address;
}
