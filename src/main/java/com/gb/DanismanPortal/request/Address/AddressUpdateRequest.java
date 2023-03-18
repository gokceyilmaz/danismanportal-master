package com.gb.DanismanPortal.request.Address;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AddressUpdateRequest {
    private int id;
    private String description;
    private String country;
    private String state;
    private String city;
    private String district;
    private String neighborhood;
    private String zipCode;
    private LocalDate create_time;
    private LocalDate endTime;
}
