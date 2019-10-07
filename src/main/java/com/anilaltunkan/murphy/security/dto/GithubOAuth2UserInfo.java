package com.anilaltunkan.murphy.security.dto;

import java.util.Map;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 21:24
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
public class GithubOAuth2UserInfo extends OAuth2UserInfo {
    public GithubOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return ((Integer) attributes.get("id")).toString();
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
        return (String) attributes.get("avatar_url");
    }
}
