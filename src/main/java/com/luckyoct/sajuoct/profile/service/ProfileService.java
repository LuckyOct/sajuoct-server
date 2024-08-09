package com.luckyoct.sajuoct.profile.service;

import com.luckyoct.sajuoct.common.Ji;
import com.luckyoct.sajuoct.common.error.exception.InvalidRequestException;
import com.luckyoct.sajuoct.profile.dao.ProfileRepository;
import com.luckyoct.sajuoct.profile.dto.ProfileDto;
import com.luckyoct.sajuoct.profile.dto.ProfileUpsertRequest;
import com.luckyoct.sajuoct.profile.entity.Profile;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public void addProfile(Long userId, ProfileDto profileDto) {
        profileRepository.save(
            Profile.builder()
                .userId(userId)
                .name(profileDto.getName())
                .sex(profileDto.getSex())
                .birthDate(profileDto.getBirthDate())
                .calendar(profileDto.getCalendar())
                .birthTime(Ji.fromTime(profileDto.getBirthTime()).getNum())
                .relation(profileDto.getRelation())
                .build()
        );
    }

    public void upsertProfile(ProfileUpsertRequest request) {
        if (request.getProfileId() == null) {
            addProfile(request.getUserId(), request.getProfile());
        } else {
            updateProfile(request.getUserId(), request.getProfileId(), request.getProfile());
        }
    }

    private void updateProfile(Long userId, Long profileId, ProfileDto profile) {
        Profile asIsProfile = getProfile(profileId);
        validateUserAndProfileId(userId, asIsProfile);

        asIsProfile.setName(profile.getName());
        asIsProfile.setSex(profile.getSex());
        asIsProfile.setBirthDate(profile.getBirthDate());
        asIsProfile.setCalendar(profile.getCalendar());
        asIsProfile.setBirthTime(Ji.fromTime(profile.getBirthTime()).getNum());
        asIsProfile.setRelation(profile.getRelation());
    }

    private Profile getProfile(Long profileId) {
        return profileRepository.findById(profileId)
            .orElseThrow(() -> new RuntimeException("Profile not found, profileId: " + profileId));
    }

    private void validateUserAndProfileId(Long userId, Profile profile) {
        if (!Objects.equals(profile.getUserId(), userId)) {
            throw new InvalidRequestException(
                String.format("Invalid profile update request, userId: %d, profileId: %d",
                    userId, profile.getProfileId()));
        }
    }

    public void deleteProfile(Long profileId) {
        profileRepository.deleteById(profileId);
    }
}
