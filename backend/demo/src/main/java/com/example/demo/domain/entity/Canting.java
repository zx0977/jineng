package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Canting {
    private Integer id;
    private String name;
    private String gender;
    private String address;
    private String phone;
    private String notes;
}
