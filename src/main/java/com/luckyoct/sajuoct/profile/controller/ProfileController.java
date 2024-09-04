package com.luckyoct.sajuoct.profile.controller;

import com.luckyoct.sajuoct.profile.dto.ProfileUpsertRequest;
import com.luckyoct.sajuoct.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("")
    public ResponseEntity<Boolean> upsertProfile(@RequestBody ProfileUpsertRequest request) {
        profileService.upsertProfile(request);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<Boolean> deleteProfile(@PathVariable("profileId") Long profileId) {
        profileService.deleteProfile(profileId);
        return ResponseEntity.ok(true);
    }
}
