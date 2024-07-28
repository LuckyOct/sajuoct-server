package com.luckyoct.sajuoct.common.webclient;

import com.luckyoct.sajuoct.user.dto.SocialUserInfoResponse;

public interface WebClientProxy {

    SocialUserInfoResponse getUserInfo(String accessToken);
}
