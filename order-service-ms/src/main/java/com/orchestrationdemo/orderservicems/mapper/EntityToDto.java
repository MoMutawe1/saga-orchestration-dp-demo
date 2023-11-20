package com.orchestrationdemo.orderservicems.mapper;

import com.orchestrationdemo.orderservicems.entity.PurchaseOrder;
import com.orchestrationdemo.orderservicems.model.OrderResponse;

public class EntityToDto {
    public static OrderResponse entityToDto(PurchaseOrder purchaseOrder) {
        System.out.println("Purchase Order Status::"+purchaseOrder.getStatus());
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(purchaseOrder.getId());
        orderResponse.setProductId(purchaseOrder.getProductId());
        orderResponse.setUserId(purchaseOrder.getUserId());
        orderResponse.setStatus(purchaseOrder.getStatus());
        orderResponse.setAmount(purchaseOrder.getPrice());
        return orderResponse;
    }
}
