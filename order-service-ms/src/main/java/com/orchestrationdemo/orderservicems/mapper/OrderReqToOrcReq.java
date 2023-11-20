package com.orchestrationdemo.orderservicems.mapper;

import com.orchestrationdemo.orderservicems.model.OrchestratorRequest;
import com.orchestrationdemo.orderservicems.model.OrderRequest;

public class OrderReqToOrcReq {
    public static OrchestratorRequest getOrchestratorRequest(OrderRequest orderRequest) {
        OrchestratorRequest orcRequest = new OrchestratorRequest();
        orcRequest.setUserId(orderRequest.getUserId());
        orcRequest.setAmount(orderRequest.getAmount());
        orcRequest.setOrderId(orderRequest.getOrderId());
        orcRequest.setProductId(orderRequest.getProductId());
        return orcRequest;
    }
}
