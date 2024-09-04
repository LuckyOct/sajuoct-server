package com.luckyoct.sajuoct.profile.dto;


import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfileView {

    private Long profileId;
    private String name;
    private Integer sex;
    private LocalDate birthDate;
    private Integer calendar;
    private Integer birthTime;
    private Relation relation;

    @QueryProjection
    public ProfileView(Long profileId, String name, Integer sex, LocalDate birthDate,
        Integer calendar, Integer birthTime, Relation relation) {
        this.profileId = profileId;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.calendar = calendar;
        this.birthTime = birthTime;
        this.relation = relation;
    }
}
