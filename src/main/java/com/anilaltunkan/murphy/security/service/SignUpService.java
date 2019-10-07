package com.anilaltunkan.murphy.security.service;

import com.anilaltunkan.murphy.security.dto.SignUpRequest;
import com.anilaltunkan.murphy.security.model.User;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 22:27
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
public interface SignUpService {
    User saveUser(SignUpRequest signUpRequest);
}
