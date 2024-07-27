package com.luckyoct.sajuoct.user.dto;

import com.luckyoct.sajuoct.profile.dto.ProfileWriteRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialLoginRequest {

    private String accessToken;
    private LoginType loginType;
    private TermsAgreement termsAgreement;
    private ProfileWriteRequest profile;
}
