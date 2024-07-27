package com.luckyoct.sajuoct.user.service.auth;

import com.luckyoct.sajuoct.common.webclient.KakaoWebClientProxyImpl;
import com.luckyoct.sajuoct.user.dto.LoginType;
import com.luckyoct.sajuoct.user.dto.SocialAuthUserInfoDto;
import com.luckyoct.sajuoct.user.dto.kakao.KakaoUserInfoResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Getter
public class KakaoAuthService implements SocialAuthService {

    private final KakaoWebClientProxyImpl kakaoWebClientProxy;
    private static final LoginType LOGIN_TYPE = LoginType.KAKAO;

    @Override
    public LoginType getLoginType() {
        return LOGIN_TYPE;
    }

    @Override
    public SocialAuthUserInfoDto getAuthUserInfo(String accessToken) {
        KakaoUserInfoResponse userInfo = kakaoWebClientProxy.getUserInfo(accessToken);

        if (!userInfo.getKakaoAccount().getIs_email_valid()
            || !userInfo.getKakaoAccount().getIs_email_verified()) {
            throw new RuntimeException("Kakao account email is not valid or verified");
        }

        return SocialAuthUserInfoDto.builder()
            .socialId(String.valueOf(userInfo.getId()))
            .emailAddress(userInfo.getKakaoAccount().getEmail())
            .loginType(LOGIN_TYPE)
            .build();
    }
}
