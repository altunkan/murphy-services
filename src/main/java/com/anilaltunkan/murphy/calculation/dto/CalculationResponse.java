package com.anilaltunkan.murphy.calculation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 28.09.2019 17:36
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Data @AllArgsConstructor
public class CalculationResponse {
    private String event;
    private BigDecimal murphy;
    private LocalDateTime eventTime;
}
