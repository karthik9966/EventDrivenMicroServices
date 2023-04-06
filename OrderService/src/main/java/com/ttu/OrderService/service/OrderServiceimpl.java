package com.ttu.OrderService.service;

import com.ttu.CommonPayload.dto.EventDto;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceimpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceimpl.class);

    private KafkaTemplate<String, EventDto> kafkaTemplate;
    private NewTopic topic;

    public OrderServiceimpl(KafkaTemplate<String,EventDto> kafkaTemplate, NewTopic topic)
    {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendEvent(EventDto eventDto)
    {
        LOGGER.info(eventDto.toString());
        Message<EventDto> message = MessageBuilder.withPayload(eventDto)
                .setHeader(KafkaHeaders.TOPIC,topic.name()).build();
        kafkaTemplate.send(message);
    }
}
