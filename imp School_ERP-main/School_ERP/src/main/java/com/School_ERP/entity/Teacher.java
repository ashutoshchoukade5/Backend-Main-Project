package com.School_ERP.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String fname;
    private String lname;
    private int age;
    private String gender;
    private String qualification;
    private String bloodGroup;
    private long contact;
    private String email;
    private String address;
    
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-mm-dd")
    private LocalDate joinDate;
}
