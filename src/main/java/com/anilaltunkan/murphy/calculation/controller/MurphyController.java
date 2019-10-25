package com.anilaltunkan.murphy.calculation.controller;

import com.anilaltunkan.murphy.calculation.dto.CalculationRequest;
import com.anilaltunkan.murphy.calculation.dto.CalculationResponse;
import com.anilaltunkan.murphy.calculation.dto.EventResponse;
import com.anilaltunkan.murphy.calculation.dto.ListEventRequest;
import com.anilaltunkan.murphy.calculation.model.CalculationStatus;
import com.anilaltunkan.murphy.calculation.service.MurphyService;
import com.anilaltunkan.murphy.err.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 28.09.2019 17:58
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@RestController
@RequestMapping("/")
public class MurphyController {
    private MurphyService murphyService;

    @Autowired
    public MurphyController(MurphyService murphyService) {
        this.murphyService = murphyService;
    }

    @PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalculationResponse> calculate(@RequestBody CalculationRequest calculationRequest, Device device) {
        CalculationResponse calculationResponse = murphyService.calculateMurphy(calculationRequest);
        String returnPath = "/id/" + calculationResponse.getCalculationId();
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath().path(returnPath).build().toUri()).body(calculationResponse);
    }

    @PostMapping(value = "/list", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<EventResponse>> listEvents(@RequestBody ListEventRequest listEventRequest, Pageable pageable) {
        return ResponseEntity.ok(murphyService.listEvents(listEventRequest, pageable));
    }

    @PutMapping(value = "/update/{calculationId}/{calculationStatus}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventResponse> updateEventStatus(@PathVariable Long calculationId, @PathVariable CalculationStatus calculationStatus) throws EntityNotFoundException {
        //throw new IllegalArgumentException("aaa");
        EventResponse eventResponse = murphyService.updateEvent(calculationId, calculationStatus);
        String returnPath = "/id/" + eventResponse.getCalculationId();
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath().path(returnPath).build().toUri()).body(eventResponse);
    }
}
