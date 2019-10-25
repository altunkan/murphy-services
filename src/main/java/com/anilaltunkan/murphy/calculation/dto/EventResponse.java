package com.anilaltunkan.murphy.calculation.dto;

import com.anilaltunkan.murphy.calculation.model.CalculationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 20.10.2019 20:44
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Data @AllArgsConstructor
public class EventResponse {
    private Long calculationId;
    private String event;
    private BigDecimal murphy;
    private LocalDateTime eventTime;
    private CalculationStatus status;
}
