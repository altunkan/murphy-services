package com.anilaltunkan.murphy.security.service;

import com.anilaltunkan.murphy.security.dto.Profile;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 23:41
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
public interface ProfileService {
    Profile getProfile(Long userId);
}
