package com.anilaltunkan.murphy.security.dto;

import com.anilaltunkan.murphy.security.exception.OAuth2AuthenticationProcessingException;
import com.anilaltunkan.murphy.security.model.AuthProvider;

import java.util.Map;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 21:24
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
public class OAuth2UserInfoFactory {
    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.github.toString())) {
            return new GithubOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
