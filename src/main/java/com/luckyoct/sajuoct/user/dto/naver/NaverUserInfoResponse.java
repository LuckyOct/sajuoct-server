package com.luckyoct.sajuoct.user.dto.naver;

import com.luckyoct.sajuoct.user.dto.SocialUserInfoResponse;
import lombok.Getter;

@Getter
public class NaverUserInfoResponse extends SocialUserInfoResponse {
    // https://developers.naver.com/docs/login/profile/profile.md

    private String resultCode;
    private String message;
    private NaverResponse response;
}
