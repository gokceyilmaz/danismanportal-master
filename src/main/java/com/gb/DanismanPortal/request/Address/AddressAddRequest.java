package com.gb.DanismanPortal.request.Address;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AddressAddRequest {
    private String description;
    private String country;
    private String state;
    private String city;
    private String district;
    private String neighborhood;
    private String zipCode;
    private LocalDate create_time = LocalDate.now();
    private LocalDate endTime;
}
