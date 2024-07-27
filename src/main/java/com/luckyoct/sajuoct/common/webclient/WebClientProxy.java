package com.luckyoct.sajuoct.common.webclient;

import com.luckyoct.sajuoct.user.dto.kakao.SocialUserInfoResponse;

public abstract class WebClientProxy {

    public abstract SocialUserInfoResponse getUserInfo(String accessToken);
}
