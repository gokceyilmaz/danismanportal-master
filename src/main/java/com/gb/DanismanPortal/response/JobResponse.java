package com.gb.DanismanPortal.response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class JobResponse {
    private int id;
    private String title;
    private String description;
    private double salary;
    private String sector;
    private String experience;
    private String company;
    private String address;
    private LocalDate createTime;
    private LocalDate endTime;
}
