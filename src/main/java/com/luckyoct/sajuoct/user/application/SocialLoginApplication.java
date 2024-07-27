package com.luckyoct.sajuoct.user.application;

import com.luckyoct.sajuoct.profile.service.ProfileService;
import com.luckyoct.sajuoct.user.dto.SocialAuthUserInfoDto;
import com.luckyoct.sajuoct.user.dto.SocialLoginRequest;
import com.luckyoct.sajuoct.user.service.UserService;
import com.luckyoct.sajuoct.user.service.auth.SocialAuthContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SocialLoginApplication {

    private final SocialAuthContext socialAuthContext;
    private final UserService userService;
    private final ProfileService profileService;

    public Long signInOrSignUp(SocialLoginRequest request) {
        SocialAuthUserInfoDto socialAuthUserInfoDto = socialAuthContext
            .getAuthUserInfo(request.getLoginType(), request.getAccessToken());
        Long userId = userService
            .signInOrSignUp(socialAuthUserInfoDto, request.getTermsAgreement());

        profileService.addProfile(userId, request.getProfile());

        return userId;
    }
}
