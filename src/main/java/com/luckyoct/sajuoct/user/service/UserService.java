package com.luckyoct.sajuoct.user.service;

import com.luckyoct.sajuoct.user.dao.UserRepository;
import com.luckyoct.sajuoct.user.dto.SocialAuthUserInfoDto;
import com.luckyoct.sajuoct.user.dto.TermsAgreement;
import com.luckyoct.sajuoct.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long signInOrSignUp(
        SocialAuthUserInfoDto socialAuthUserInfoDto, TermsAgreement termsAgreement) {
        User user = userRepository.findBySocialIdAndLoginType(socialAuthUserInfoDto.getSocialId(),
                socialAuthUserInfoDto.getLoginType())
            .orElseGet(() -> createUser(socialAuthUserInfoDto));
        updateTermsOfServiceAgreement(user, termsAgreement);
        return user.getUserId();
    }

    private User createUser(SocialAuthUserInfoDto socialAuthUserInfoDto) {
        return userRepository.save(
            User.builder()
                .loginType(socialAuthUserInfoDto.getLoginType())
                .emailAddress(socialAuthUserInfoDto.getEmailAddress())
                .socialId(socialAuthUserInfoDto.getSocialId())
                .build());
    }

    public void updateTermsOfServiceAgreement(User user, TermsAgreement termsAgreement) {
        user.setAgreeToReceiveMarketing(termsAgreement.isMarketing());
        userRepository.save(user);
    }
}
