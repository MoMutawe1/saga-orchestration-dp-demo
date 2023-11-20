package com.orchestrationdemo.orderservicems.entity;

import com.orchestrationdemo.orderservicems.model.constant.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {
    @Id
    private String id;
    private Integer userId;
    private Integer productId;
    private Double price;
    private OrderStatus status;
}
