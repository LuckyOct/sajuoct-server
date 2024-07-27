package com.luckyoct.sajuoct.user.service.auth;

import com.luckyoct.sajuoct.user.dto.LoginType;
import com.luckyoct.sajuoct.user.dto.SocialAuthUserInfoDto;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SocialAuthContext {

    private final List<SocialAuthService> socialAuthServices;
    private Map<LoginType, SocialAuthService> socialAuthServiceMap;

    @PostConstruct
    void init() {
        socialAuthServiceMap = socialAuthServices.stream()
            .collect(Collectors.toMap(SocialAuthService::getLoginType, Function.identity()));
    }

    public SocialAuthUserInfoDto getAuthUserInfo(LoginType loginType, String accessToken) {
        SocialAuthService socialAuthService = socialAuthServiceMap.get(loginType);
        if (socialAuthService == null) {
            throw new IllegalArgumentException("Invalid login type");
        }
        return socialAuthService.getAuthUserInfo(accessToken);
    }
}
