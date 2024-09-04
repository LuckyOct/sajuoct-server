package com.luckyoct.sajuoct.profile.service;

import com.luckyoct.sajuoct.common.Ji;
import com.luckyoct.sajuoct.common.error.exception.InvalidRequestException;
import com.luckyoct.sajuoct.profile.dao.ProfileRepository;
import com.luckyoct.sajuoct.profile.dto.ProfileUpsertDetail;
import com.luckyoct.sajuoct.profile.dto.ProfileUpsertRequest;
import com.luckyoct.sajuoct.profile.dto.ProfileViewList;
import com.luckyoct.sajuoct.profile.entity.Profile;
import com.luckyoct.sajuoct.user.entity.User;
import com.luckyoct.sajuoct.user.service.UserService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserService userService;

    public void addProfile(Long userId, ProfileUpsertDetail profileUpsertDetail) {
        User user = userService.findById(userId);
        profileRepository.save(
            Profile.builder()
                .user(user)
                .name(profileUpsertDetail.getName())
                .sex(profileUpsertDetail.getSex())
                .birthDate(profileUpsertDetail.getBirthDate())
                .calendar(profileUpsertDetail.getCalendar())
                .birthTime(Ji.fromTime(profileUpsertDetail.getBirthTime()).getNum())
                .relation(profileUpsertDetail.getRelation())
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

    private void updateProfile(Long userId, Long profileId, ProfileUpsertDetail profile) {
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
        if (!Objects.equals(profile.getUser().getUserId(), userId)) {
            throw new InvalidRequestException(
                String.format("Invalid profile update request, userId: %d, profileId: %d",
                    userId, profile.getProfileId()));
        }
    }

    public void deleteProfile(Long profileId) {
        profileRepository.deleteById(profileId);
    }

    public ProfileViewList getUserProfileViewList(Long userId) {
        return ProfileViewList.builder()
            .profiles(profileRepository.queryUserProfiles(userId))
            .build();
    }
}
