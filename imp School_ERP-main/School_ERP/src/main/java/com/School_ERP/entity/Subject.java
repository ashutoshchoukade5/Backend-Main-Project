package com.School_ERP.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;



@Entity
@Table(name = "subject")
@Data
@Getter
@Setter
public class Subject {

    @Id
    @Column(name = "sub_code")
    private Long subCode;

    @Column(name = "sub_name")
    private String subName;

    @Column(name = "days")
    private String days;

    @Column(name = "weekly_classes")
    private Integer weeklyClasses;

    @OneToMany(mappedBy = "subject")
    private Set<Student> students;

}
