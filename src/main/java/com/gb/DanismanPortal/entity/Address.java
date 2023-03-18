package com.gb.DanismanPortal.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "address")
@Where(clause = "end_time is null")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "country")
    private String country;     //ülke

    @Column(name = "state")
    private String state;       //eyalet

    @Column(name = "city")
    private String city;        //il

    @Column(name = "district")
    private String district;    //ilçe

    @Column(name = "neighborhood")
    private String neighborhood;//mahalle

    @Column(name = "zip_code")
    private String zipCode;     //posta kodu

    @Column(name = "create_time")
    private LocalDate create_time = LocalDate.now() ;

    @Column(name = "end_time")
    private LocalDate endTime;
}
