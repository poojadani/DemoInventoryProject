package com.example.Product.Inventory.Management.Repository;

import com.example.Product.Inventory.Management.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity,Long> {
}
