package com.anilaltunkan.murphy.err;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 03.10.2019 09:40
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
class ApiValidationError implements ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}
