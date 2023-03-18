package com.gb.DanismanPortal.repository;

import com.gb.DanismanPortal.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
