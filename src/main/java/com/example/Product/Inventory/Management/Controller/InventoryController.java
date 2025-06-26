package com.example.Product.Inventory.Management.Controller;

import com.example.Product.Inventory.Management.Dto.InventoryDto;
import com.example.Product.Inventory.Management.Entity.InventoryEntity;
import com.example.Product.Inventory.Management.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/Inventory")
public class InventoryController
{
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/inventory")
    public ResponseEntity<InventoryEntity> addInventory(@RequestBody InventoryDto inventoryDto){
        return new ResponseEntity<>(inventoryService.addInventory(inventoryDto), CREATED);
    }

    @PutMapping("/inventory/{productId}")
    public ResponseEntity<InventoryEntity> updateQuantity(@RequestBody InventoryDto inventoryDto,@PathVariable Long productId){
        InventoryEntity inventoryEntity=inventoryService.updateQuantity(productId,inventoryDto);
        return ResponseEntity.ok(inventoryEntity);
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<InventoryEntity>>ViewAllInventoryDetails(){
        List<InventoryEntity> inventoryEntity=inventoryService.ViewAllInventoryDetails();
        return new ResponseEntity<>(inventoryEntity,CREATED);
    }

}
