package com.ttu.StockService.service;

import com.ttu.CommonPayload.dto.EventDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockServiceImpl.class);

    @KafkaListener(topics = "${spring.topic.name}", groupId = "${spring.kafka.consumer.groupId}")
    public void receiveEvent(EventDto eventDto)
    {
        LOGGER.info(eventDto.toString());
    }
}
