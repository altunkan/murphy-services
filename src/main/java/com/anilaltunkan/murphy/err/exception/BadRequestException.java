package com.anilaltunkan.murphy.err.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 22:02
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
