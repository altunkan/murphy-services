package com.anilaltunkan.murphy.util;

import com.anilaltunkan.murphy.security.dto.UserPrincipal;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 03.10.2019 09:26
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        return Optional.of(((UserPrincipal)authentication.getPrincipal()).getUsername());
    }
}
