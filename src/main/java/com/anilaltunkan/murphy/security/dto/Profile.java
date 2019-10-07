package com.anilaltunkan.murphy.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 29.09.2019 23:37
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Data @EqualsAndHashCode(of = {"userId"}) @AllArgsConstructor
public class Profile {
    private Long userId;
    private String email;
}
