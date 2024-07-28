package com.luckyoct.sajuoct.user.service.auth;

import com.luckyoct.sajuoct.common.webclient.GoogleWebClientProxyImpl;
import com.luckyoct.sajuoct.user.dto.LoginType;
import com.luckyoct.sajuoct.user.dto.SocialAuthUserInfoDto;
import com.luckyoct.sajuoct.user.dto.google.GoogleUserInfo;
import com.luckyoct.sajuoct.user.dto.google.GoogleUserInfoResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Getter
public class GoogleAuthService implements SocialAuthService {

    private final GoogleWebClientProxyImpl googleWebClientProxy;
    private static final LoginType LOGIN_TYPE = LoginType.GOOGLE;

    @Override
    public LoginType getLoginType() {
        return LOGIN_TYPE;
    }

    @Override
    public SocialAuthUserInfoDto getAuthUserInfo(String accessToken) {
        GoogleUserInfoResponse response = googleWebClientProxy.getUserInfo(accessToken);
        validateResponse(response);
        GoogleUserInfo userInfo = response.getUsers().get(0);

        return SocialAuthUserInfoDto.builder()
            .socialId(userInfo.getLocalId())
            .emailAddress(userInfo.getEmail())
            .loginType(LOGIN_TYPE)
            .build();
    }

    public void validateResponse(GoogleUserInfoResponse response) {
        if (response.getUsers().size() != 1) {
            throw new RuntimeException(
                String.format("Google User response size is not 1 (size: %d)",
                    response.getUsers().size()));
        }
        if (!response.getUsers().get(0).getEmailVerified()) {
            throw new RuntimeException("Google account email is not verified");
        }
    }
}
