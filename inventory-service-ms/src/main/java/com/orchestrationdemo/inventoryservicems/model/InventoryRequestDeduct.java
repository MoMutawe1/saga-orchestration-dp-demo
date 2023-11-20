package com.orchestrationdemo.inventoryservicems.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequestDeduct {
    private String productId;
    private String productName;
    private int quantity;
}
