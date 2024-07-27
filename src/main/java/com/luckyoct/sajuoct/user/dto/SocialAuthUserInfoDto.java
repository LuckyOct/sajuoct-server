package com.luckyoct.sajuoct.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialAuthUserInfoDto {

    private String socialId;
    private String emailAddress;
    private LoginType loginType;
}
