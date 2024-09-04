package com.luckyoct.sajuoct.user.controller;

import com.luckyoct.sajuoct.profile.dto.ProfileViewList;
import com.luckyoct.sajuoct.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final ProfileService profileService;

    @GetMapping("/{userId}/profiles")
    public ResponseEntity<ProfileViewList> getUserProfiles(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(profileService.getUserProfileViewList(userId));
    }
}
