package com.orchestrationdemo.orderservicems.repository;

import com.orchestrationdemo.orderservicems.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRespository extends ReactiveCrudRepository<PurchaseOrder, String> {
}
