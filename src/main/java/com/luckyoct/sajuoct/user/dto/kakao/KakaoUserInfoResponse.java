package com.luckyoct.sajuoct.user.dto.kakao;

import lombok.Getter;

@Getter
public class KakaoUserInfoResponse extends SocialUserInfoResponse {
    // https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#req-user-info-response

    private KakaoAccount kakaoAccount;
}
