package com.example.Product.Inventory.Management.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Product")
public class ProductEntity
{

        @GeneratedValue(strategy = GenerationType.IDENTITY)

        @Id
        private long productID;

        @NotBlank
        private String productName;
        private String productDescr;
       // @Min(0)
        private double price;

        //@NotBlank
        private String category;

       // @NotBlank
        private String unit;



        public long getProductID() {
                return productID;
        }

        public void setProductID(long productID) {
                this.productID = productID;
        }

        public String getProductName() {
                return productName;
        }

        public void setProductName(String productName) {
                this.productName = productName;
        }

        public String getProductDescr() {
                return productDescr;
        }

        public void setProductDescr(String productDescr) {
                this.productDescr = productDescr;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public String getUnit() {
                return unit;
        }

        public void setUnit(String unit) {
                this.unit = unit;
        }




}
