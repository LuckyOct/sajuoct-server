package com.luckyoct.sajuoct.profile.dao;

import com.luckyoct.sajuoct.profile.dto.ProfileView;
import java.util.List;

public interface ProfileQueryDsl {

    List<ProfileView> queryUserProfiles(Long userId);
}
