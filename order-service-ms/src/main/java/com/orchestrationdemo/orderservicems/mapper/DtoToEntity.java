package com.orchestrationdemo.orderservicems.mapper;

import com.orchestrationdemo.orderservicems.entity.PurchaseOrder;
import com.orchestrationdemo.orderservicems.model.OrderRequest;
import com.orchestrationdemo.orderservicems.model.constant.OrderStatus;

public class DtoToEntity {

    public static PurchaseOrder dtoToEntity(final OrderRequest orderRequest) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(orderRequest.getOrderId());
        purchaseOrder.setProductId(orderRequest.getProductId());
        purchaseOrder.setUserId(orderRequest.getUserId());
        purchaseOrder.setStatus(OrderStatus.ORDER_CREATED);
        purchaseOrder.setPrice(orderRequest.getAmount());
        return purchaseOrder;
    }
}
