package com.luckyoct.sajuoct.profile.dao;

import static com.luckyoct.sajuoct.profile.entity.QProfile.profile;
import static com.luckyoct.sajuoct.user.entity.QUser.user;

import com.luckyoct.sajuoct.profile.dto.ProfileView;
import com.luckyoct.sajuoct.profile.dto.QProfileView;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProfileQueryDslImpl implements ProfileQueryDsl {

    private final JPAQueryFactory queryFactory;

    public List<ProfileView> queryUserProfiles(Long userId) {
        return queryFactory.select(new QProfileView(
                profile.profileId,
                profile.name,
                profile.sex,
                profile.birthDate,
                profile.calendar,
                profile.birthTime,
                profile.relation))
            .from(profile)
            .leftJoin(profile.user, user)
            .where(user.userId.eq(userId))
            .fetch();
    }
}
