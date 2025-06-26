package com.example.Product.Inventory.Management.Service;

import com.example.Product.Inventory.Management.Dto.InventoryDto;
import com.example.Product.Inventory.Management.Entity.InventoryEntity;
import com.example.Product.Inventory.Management.Entity.ProductEntity;
import com.example.Product.Inventory.Management.Exception.ProductNotFoundException;
import com.example.Product.Inventory.Management.Repository.InventoryRepo;
import com.example.Product.Inventory.Management.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class InventoryService
{

    @Autowired
    InventoryRepo inventoryRepo;
    @Autowired
    ProductRepo productRepo;


    public InventoryEntity addInventory(InventoryDto inventoryDto)
    {
        ProductEntity product = productRepo.findById(inventoryDto.getProductId()).orElseThrow(() ->
                                new ProductNotFoundException("Sorry!!  Product not found for ID: " + inventoryDto.getProductId()));

        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setAvailableQuantity(inventoryDto.getAvailableQuantity());
        inventoryEntity.setProductEntity(product);
        return inventoryRepo.save(inventoryEntity);
    }



    public InventoryEntity updateQuantity(Long productId, InventoryDto inventoryDto)
    {
        ProductEntity productEntity=productRepo.findById(productId).orElseThrow(()->
                                    new ProductNotFoundException("Sorry!! Product Not Found"));
        InventoryEntity inventoryEntity=new InventoryEntity();
        inventoryEntity.setAvailableQuantity(inventoryDto.getAvailableQuantity());

//        inventoryEntity.setLastUpdated(inventoryDto.getLastUpdated());
//        inventoryEntity.setUpdatedBy(inventoryDto.getUpdatedBy());
//        inventoryEntity.setUpdatedDate(LocalDateTime.now());

        return inventoryRepo.save(inventoryEntity);
    }

    public List<InventoryEntity> ViewAllInventoryDetails()
    {
        List<InventoryEntity> inventoryEntity = inventoryRepo.findAll();
        return inventoryEntity;

    }
}
