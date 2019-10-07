package com.anilaltunkan.murphy.security.controller;

import com.anilaltunkan.murphy.security.dto.Profile;
import com.anilaltunkan.murphy.security.dto.UserPrincipal;
import com.anilaltunkan.murphy.security.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 22:58
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("/me")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Profile> getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return ResponseEntity.ok(profileService.getProfile(userPrincipal.getUserId()));
    }
}
