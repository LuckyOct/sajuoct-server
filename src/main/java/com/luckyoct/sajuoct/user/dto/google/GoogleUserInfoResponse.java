package com.luckyoct.sajuoct.user.dto.google;

import com.luckyoct.sajuoct.user.dto.SocialUserInfoResponse;
import java.util.List;
import lombok.Getter;

@Getter
public class GoogleUserInfoResponse extends SocialUserInfoResponse {

    private List<GoogleUserInfo> users;
}
