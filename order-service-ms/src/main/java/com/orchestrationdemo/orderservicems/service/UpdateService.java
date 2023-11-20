package com.orchestrationdemo.orderservicems.service;

import com.orchestrationdemo.orderservicems.model.OrchestratorResponse;
import com.orchestrationdemo.orderservicems.repository.PurchaseOrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateService {

    @Autowired
    private PurchaseOrderRespository repo;

    public Mono<Void> updateOrder(OrchestratorResponse response) {
        System.out.println("Response::"+response.getStatus());

        return repo.findById(response.getOrderId())
                .doOnNext(p -> p.setStatus(response.getStatus()))
                .doOnNext(repo::save)
                .then();
    }
}
