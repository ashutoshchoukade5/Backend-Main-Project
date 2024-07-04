package com.School_ERP.dto;

import lombok.Data;

@Data
public class SubjectDto {
    private Long subCode; // Change to Long if necessary
    private String subName;
    private String days;
    private Integer weeklyClasses;

    // Constructor, getters, and setters
    public SubjectDto(Long subCode, String subName, String days, Integer weeklyClasses) {
        this.subCode = subCode;
        this.subName = subName;
        this.days = days;
        this.weeklyClasses = weeklyClasses;
    }
}
