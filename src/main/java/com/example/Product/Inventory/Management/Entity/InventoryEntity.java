package com.example.Product.Inventory.Management.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Inventory")
public class InventoryEntity
{

    @Id
    private Long Id;
    private int availableQuantity;
    private LocalDateTime lastUpdated;

    @OneToOne
    @JoinColumn(name = "product_id",nullable = false,unique = true)
    private ProductEntity productEntity;

    public Long getProductId() {
        return Id;
    }

    public void setProductId(Long productId) {
        this.Id = productId;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
