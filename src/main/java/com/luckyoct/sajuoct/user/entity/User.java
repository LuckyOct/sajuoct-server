package com.luckyoct.sajuoct.user.entity;

import com.luckyoct.sajuoct.common.BaseEntity;
import com.luckyoct.sajuoct.profile.entity.Profile;
import com.luckyoct.sajuoct.user.dto.LoginType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long userId;

    @Column
    private LoginType loginType;

    @Column
    private String emailAddress;

    @Column
    private String socialId;

    @Column
    private Boolean agreeToReceiveMarketing;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Profile> profiles = new ArrayList<>();
}
