package com.orchestrationdemo.orderservicems.service;

import com.orchestrationdemo.orderservicems.entity.PurchaseOrder;
import com.orchestrationdemo.orderservicems.mapper.DtoToEntity;
import com.orchestrationdemo.orderservicems.mapper.EntityToDto;
import com.orchestrationdemo.orderservicems.mapper.OrderReqToOrcReq;
import com.orchestrationdemo.orderservicems.model.OrchestratorRequest;
import com.orchestrationdemo.orderservicems.model.OrderRequest;
import com.orchestrationdemo.orderservicems.model.OrderResponse;
import com.orchestrationdemo.orderservicems.repository.PurchaseOrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import static com.orchestrationdemo.orderservicems.mapper.DtoToEntity.dtoToEntity;
import static com.orchestrationdemo.orderservicems.mapper.EntityToDto.entityToDto;

@Service
public class OrderService {

    @Autowired
    private PurchaseOrderRespository repository;

    @Autowired
    private Sinks.Many<OrchestratorRequest> sink;

    public Mono<PurchaseOrder> createOrder(OrderRequest orderRequest) {
        return repository.save(dtoToEntity(orderRequest))
                .doOnNext(e -> orderRequest.setOrderId(e.getId()))
                .doOnNext(e -> emitEvent(orderRequest)); // sending events to Kafka broker.
    }

    public Flux<OrderResponse> getAllOrder() {
        return repository.findAll()
                .map((purchaseOrder) -> entityToDto(purchaseOrder));
    }

    private void emitEvent(OrderRequest orderRequestDTO) {
        sink.tryEmitNext(OrderReqToOrcReq.getOrchestratorRequest(orderRequestDTO));
    }
}
