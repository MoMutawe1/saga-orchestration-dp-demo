package com.orchestrationdemo.inventoryservicems.controller;

import com.orchestrationdemo.inventoryservicems.model.InventoryRequestAdd;
import com.orchestrationdemo.inventoryservicems.model.InventoryRequestDeduct;
import com.orchestrationdemo.inventoryservicems.model.InventoryResponse;
import com.orchestrationdemo.inventoryservicems.model.InventoryStatus;
import com.orchestrationdemo.inventoryservicems.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping("/addItem")
    public ResponseEntity<Void> addItem(@RequestBody InventoryRequestAdd inventoryRequest){
        inventoryService.addItem(inventoryRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/deductItem")
    public ResponseEntity<InventoryResponse> deductItem(@RequestBody InventoryRequestDeduct inventoryRequest){

        String productId = inventoryRequest.getProductId();
        String productName = inventoryRequest.getProductName();
        InventoryStatus status = inventoryService.deduct(inventoryRequest);

        InventoryResponse response = InventoryResponse.builder()
                .productId(productId)
                .productName(productName)
                .status(status)
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
