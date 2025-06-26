package com.example.Product.Inventory.Management.Repository;

import com.example.Product.Inventory.Management.Entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<InventoryEntity,Long> {

}
