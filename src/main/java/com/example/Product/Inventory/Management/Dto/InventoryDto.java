package com.example.Product.Inventory.Management.Dto;

import com.example.Product.Inventory.Management.Entity.ProductEntity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto
{
    private Long Id;
   // @Min(0)
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
}
