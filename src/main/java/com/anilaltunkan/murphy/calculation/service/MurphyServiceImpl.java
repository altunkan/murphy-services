package com.anilaltunkan.murphy.calculation.service;

import com.anilaltunkan.murphy.calculation.dto.CalculationRequest;
import com.anilaltunkan.murphy.calculation.dto.CalculationResponse;
import com.anilaltunkan.murphy.calculation.dto.EventResponse;
import com.anilaltunkan.murphy.calculation.dto.ListEventRequest;
import com.anilaltunkan.murphy.calculation.model.Calculation;
import com.anilaltunkan.murphy.calculation.model.CalculationStatus;
import com.anilaltunkan.murphy.calculation.repository.CalculationRepository;
import com.anilaltunkan.murphy.err.exception.BadRequestException;
import com.anilaltunkan.murphy.err.exception.EntityNotFoundException;
import com.google.common.base.Strings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @Author: MEHMET ANIL ALTUNKAN
 * @Date: 28.09.2019 17:40
 * @Mobile: +905333618547
 * @Email: altunkan@gmail.com
 **/
@Service
public class MurphyServiceImpl implements MurphyService {
    private static final Logger _logger = LogManager.getLogger(MurphyServiceImpl.class);

    private CalculationRepository calculationRepository;

    @Autowired
    public MurphyServiceImpl(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    @Override
    public CalculationResponse calculateMurphy(CalculationRequest calculationRequest) {
        BigDecimal one = BigDecimal.ONE;
        BigDecimal ten = BigDecimal.TEN;
        BigDecimal twenty = BigDecimal.TEN.multiply(BigDecimal.valueOf(2));
        BigDecimal aggravation = BigDecimal.valueOf(0.7);
        BigDecimal complexity = calculationRequest.getComplexity();
        BigDecimal urgency = calculationRequest.getUrgency();
        BigDecimal importance = calculationRequest.getImportance();
        BigDecimal skill = calculationRequest.getSkill();
        BigDecimal frequency = calculationRequest.getFrequency();
        String event = calculationRequest.getEvent();
        LocalDateTime eventTime = calculationRequest.getEventTime();


        BigDecimal first = ((urgency
                .add(complexity)
                .add(importance))
                .multiply(ten.subtract(skill))).divide(twenty, 3, RoundingMode.HALF_EVEN);
        _logger.info("First {}", first);
        BigDecimal second = aggravation;
        _logger.info("Second {}", second);

        BigDecimal third = one.divide((one.subtract(BigDecimal.valueOf(Math.sin(frequency.divide(ten, 3, RoundingMode.HALF_EVEN).doubleValue())))), 3, RoundingMode.HALF_EVEN);
        _logger.info("Third {}", third);
        BigDecimal murphy = first.multiply(second).multiply(third).setScale(3, RoundingMode.HALF_EVEN);
        Calculation calculation = new Calculation();
        calculation.setComplexity(complexity);
        calculation.setEvent(event);
        calculation.setEventTime(eventTime);
        calculation.setFrequency(frequency);
        calculation.setImportance(importance);
        calculation.setSkill(skill);
        calculation.setUrgency(urgency);
        calculation.setStatus(CalculationStatus.NEW);
        calculation.setMurphy(murphy);
        calculation = calculationRepository.save(calculation);
        return new CalculationResponse(calculation.getCalculationId(), calculation.getEvent(), calculation.getMurphy(), calculation.getEventTime());
    }

    @Override
    public Page<EventResponse> listEvents(ListEventRequest listEventRequest, Pageable pageable) {
        String email = listEventRequest.getEmail();
        if (Strings.isNullOrEmpty(email)) {
            throw new BadRequestException("Email is required!");
        }

        Page<Calculation> calculationPage = calculationRepository.findByCreatedBy(email, pageable);
        Page<EventResponse> listEventResponsePage = calculationPage.map(
                calculation -> new EventResponse(calculation.getCalculationId(), calculation.getEvent(), calculation.getMurphy(), calculation.getEventTime(), calculation.getStatus())
        );
        return listEventResponsePage;
    }

    @Override
    public EventResponse updateEvent(Long calculationId, CalculationStatus calculationStatus) throws EntityNotFoundException {
        Optional<Calculation> calculationOptional = calculationRepository.findById(calculationId);
        if (!calculationOptional.isPresent())
            throw new EntityNotFoundException(Calculation.class, "calculationId", calculationId.toString());

        Calculation calculation = calculationOptional.get();
        calculation.setStatus(calculationStatus);
        calculation = calculationRepository.save(calculation);
        return new EventResponse(calculation.getCalculationId(), calculation.getEvent(), calculation.getMurphy(), calculation.getEventTime(), calculation.getStatus());
    }
}
