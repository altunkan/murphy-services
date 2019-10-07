package com.anilaltunkan.murphy.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 21:28
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
public class OAuth2AuthenticationProcessingException extends AuthenticationException {
    public OAuth2AuthenticationProcessingException(String msg, Throwable t) {
        super(msg, t);
    }

    public OAuth2AuthenticationProcessingException(String msg) {
        super(msg);
    }
}
