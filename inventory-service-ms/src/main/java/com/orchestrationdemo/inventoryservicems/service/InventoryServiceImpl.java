package com.orchestrationdemo.inventoryservicems.service;

import com.orchestrationdemo.inventoryservicems.entity.Inventory;
import com.orchestrationdemo.inventoryservicems.model.InventoryRequestAdd;
import com.orchestrationdemo.inventoryservicems.model.InventoryRequestDeduct;
import com.orchestrationdemo.inventoryservicems.model.InventoryStatus;
import com.orchestrationdemo.inventoryservicems.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.orchestrationdemo.inventoryservicems.model.InventoryStatus.AVAILABLE;
import static com.orchestrationdemo.inventoryservicems.model.InventoryStatus.UNAVAILABLE;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public void addItem(InventoryRequestAdd inventoryRequest) {
        String productId = UUID.randomUUID().toString();
        String status = String.valueOf(AVAILABLE);

        Inventory inventory = Inventory.builder()
                .productId(productId)
                .productName(inventoryRequest.getProductName())
                .quantity(inventoryRequest.getQuantity())
                .status(status)
                .build();

        inventoryRepository.save(inventory);
    }

    @Override
    public InventoryStatus deduct(InventoryRequestDeduct inventoryRequest) {

        String productId = inventoryRequest.getProductId().toString();

        // check if requested item is available in the inventory for purchase.
        Inventory inventoryInfo = inventoryRepository.findById(productId).get();
        int totalQuantity = inventoryInfo.getQuantity() - inventoryRequest.getQuantity();

        // update the product quantity by deducting requested item from DB.
        if(totalQuantity >= 0) {
            Inventory inventory =
                    Inventory.builder()
                            .productId(inventoryRequest.getProductId())
                            .status(String.valueOf(AVAILABLE))
                            .quantity(totalQuantity)
                    .build();
            inventoryRepository.save(inventory);
            return AVAILABLE;
        } else { return UNAVAILABLE; }
    }
}
