package com.luckyoct.sajuoct.profile.dto;


import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileWriteRequest {

    private String name;
    private Integer sex;
    private LocalDate birthDate;
    private Integer calendar;
    private LocalTime birthTime;
    private Relation relation;
}
