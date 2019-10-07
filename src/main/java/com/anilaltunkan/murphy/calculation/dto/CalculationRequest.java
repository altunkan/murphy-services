package com.anilaltunkan.murphy.calculation.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 28.09.2019 17:36
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Data
public class CalculationRequest {
    private String event;
    private BigDecimal urgency;
    private BigDecimal importance;
    private BigDecimal complexity;
    private BigDecimal skill;
    private BigDecimal frequency;
    private LocalDateTime eventTime;
}
