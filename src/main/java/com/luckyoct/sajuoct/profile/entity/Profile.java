package com.luckyoct.sajuoct.profile.entity;

import com.luckyoct.sajuoct.common.BaseEntity;
import com.luckyoct.sajuoct.profile.dto.Relation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "profile")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Profile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long profileId;

    @Column
    private Long userId;

    @Column
    private String name;

    @Column
    private LocalDate birthDate;

    @Column
    private Integer birthTime;

    @Column
    private Integer sex;

    @Column
    private Integer calendar;

    @Column
    @Enumerated(EnumType.STRING)
    private Relation relation;
}
