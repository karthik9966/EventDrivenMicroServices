package com.ttu.CommonPayload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String orderId;
    private String orderName;
    private Long orderQuantity;
    private Long orderPrice;
}
