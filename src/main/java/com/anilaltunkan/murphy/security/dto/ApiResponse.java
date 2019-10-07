package com.anilaltunkan.murphy.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 22:19
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Data @AllArgsConstructor
public class ApiResponse {
    private boolean success;
    private String message;
}
