package com.anilaltunkan.murphy.security.dto;

import java.util.Map;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 21:20
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
public abstract class OAuth2UserInfo {
    protected Map<String, Object> attributes;

    public OAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public abstract String getId();

    public abstract String getName();

    public abstract String getEmail();

    public abstract String getImageUrl();
}
