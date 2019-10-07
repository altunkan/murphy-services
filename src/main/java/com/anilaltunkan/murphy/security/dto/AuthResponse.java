package com.anilaltunkan.murphy.security.dto;

import lombok.Data;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 22:19
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Data
public class AuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
