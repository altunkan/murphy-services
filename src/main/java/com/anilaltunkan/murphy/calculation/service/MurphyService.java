package com.anilaltunkan.murphy.calculation.service;

import com.anilaltunkan.murphy.calculation.dto.CalculationRequest;
import com.anilaltunkan.murphy.calculation.dto.CalculationResponse;
import com.anilaltunkan.murphy.calculation.dto.EventResponse;
import com.anilaltunkan.murphy.calculation.dto.ListEventRequest;
import com.anilaltunkan.murphy.calculation.model.CalculationStatus;
import com.anilaltunkan.murphy.err.exception.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 28.09.2019 17:37
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
public interface MurphyService {
    CalculationResponse calculateMurphy(CalculationRequest calculationRequest);

    Page<EventResponse> listEvents(ListEventRequest listEventRequest, Pageable pageable);

    EventResponse updateEvent(Long calculationId, CalculationStatus calculationStatus) throws EntityNotFoundException;
}
