package com.orchestrationdemo.inventoryservicems.service;

import com.orchestrationdemo.inventoryservicems.model.InventoryRequestAdd;
import com.orchestrationdemo.inventoryservicems.model.InventoryRequestDeduct;
import com.orchestrationdemo.inventoryservicems.model.InventoryStatus;

public interface InventoryService {
    InventoryStatus deduct(InventoryRequestDeduct request);
    void addItem(InventoryRequestAdd inventoryRequest);
}
