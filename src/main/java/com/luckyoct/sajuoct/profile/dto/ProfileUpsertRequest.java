package com.luckyoct.sajuoct.profile.dto;


import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpsertRequest {

    private Long userId;
    @Nullable
    private Long profileId;
    private ProfileDto profile;
}
