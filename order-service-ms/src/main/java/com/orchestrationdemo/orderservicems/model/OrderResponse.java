package com.orchestrationdemo.orderservicems.model;

import com.orchestrationdemo.orderservicems.model.constant.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private String orderId;
    private Integer userId;
    private Integer productId;
    private Double amount;
    private OrderStatus status;
}
