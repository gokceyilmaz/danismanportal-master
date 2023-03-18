package com.gb.DanismanPortal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employee")
@Where(clause = "end_time is null")
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "sector")
    private String sector;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private double salary;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "company")
    private String company;

    @Column(name = "linkedin_username")
    private String linkedinUsername;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "create_time")
    private LocalDate createTime;

    @Column(name = "end_time")
    private LocalDate endTime;
}
