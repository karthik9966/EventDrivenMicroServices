package com.ttu.OrderService.controller;

import com.ttu.CommonPayload.dto.EventDto;
import com.ttu.CommonPayload.dto.OrderDto;
import com.ttu.OrderService.service.OrderServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/app/order")
public class OrderController {

    @Autowired
    private OrderServiceimpl orderServiceimpl;

    @PostMapping
    public String submitOrder(@RequestBody OrderDto orderDto)
    {
        orderDto.setOrderId(UUID.randomUUID().toString());
        EventDto eventDto = new EventDto();
        eventDto.setStatus("PENDING");
        eventDto.setMessage("Order revceived and under process");
        eventDto.setOrderDto(orderDto);
        orderServiceimpl.sendEvent(eventDto);
        return eventDto.getMessage();
    }
}
