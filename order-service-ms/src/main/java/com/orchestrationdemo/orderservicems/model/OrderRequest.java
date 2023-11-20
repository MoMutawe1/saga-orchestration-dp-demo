package com.orchestrationdemo.orderservicems.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Integer userId;
    private Integer productId;
    private String orderId;
    private Double amount;
}
