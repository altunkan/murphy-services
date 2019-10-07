package com.anilaltunkan.murphy.security.dto;

import java.util.Map;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 21:22
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
public class GoogleOAuth2UserInfo extends OAuth2UserInfo {
    public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("sub");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getImageUrl() {
        return (String) attributes.get("picture");
    }
}
