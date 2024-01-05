package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@Data
@Builder
@Table
@Entity // is an jpa entity  mapped with relation in database, every instance of entity is a row of table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String email;
    @JsonProperty
    private LocalDate dob;
    @JsonProperty
    @Transient
    private Integer age;
    public Student(){
    }

    public Integer getAge() {
        return Period.between(dob,LocalDate.now()).getYears();
    }
}
