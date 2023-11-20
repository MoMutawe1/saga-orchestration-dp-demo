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
public class OrchestratorResponse {
    private Integer userId;
    private Integer productId;
    private String orderId;
    private Double amount;
    private OrderStatus status;
}
