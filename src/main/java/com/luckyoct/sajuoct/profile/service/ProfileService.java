package com.luckyoct.sajuoct.profile.service;

import com.luckyoct.sajuoct.common.Ji;
import com.luckyoct.sajuoct.profile.dao.ProfileRepository;
import com.luckyoct.sajuoct.profile.dto.ProfileWriteRequest;
import com.luckyoct.sajuoct.profile.entity.Profile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public void addProfile(Long userId, ProfileWriteRequest profileWriteRequest) {
        profileRepository.save(
            Profile.builder()
                .userId(userId)
                .name(profileWriteRequest.getName())
                .sex(profileWriteRequest.getSex())
                .birthDate(profileWriteRequest.getBirthDate())
                .calendar(profileWriteRequest.getCalendar())
                .birthTime(Ji.fromTime(profileWriteRequest.getBirthTime()).getNum())
                .relation(profileWriteRequest.getRelation())
                .build()
        );
    }
}
