package com.luckyoct.sajuoct.user.service.auth;

import com.luckyoct.sajuoct.user.dto.LoginType;
import com.luckyoct.sajuoct.user.dto.SocialAuthUserInfoDto;

public interface SocialAuthService {

    SocialAuthUserInfoDto getAuthUserInfo(String accessToken);

    LoginType getLoginType();
}
