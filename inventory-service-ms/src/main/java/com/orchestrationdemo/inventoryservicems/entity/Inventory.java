package com.orchestrationdemo.inventoryservicems.entity;

import com.orchestrationdemo.inventoryservicems.model.InventoryStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    /*@Column(name = "USER_ID")
    private UUID userId;*/

    /*@Column(name = "ORDER_ID")
    private UUID orderId;*/

    @Id
    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "INVENTORY_STATUS")
    private String status;

    @Column(name = "QUANTITY")
    private int quantity;
}
