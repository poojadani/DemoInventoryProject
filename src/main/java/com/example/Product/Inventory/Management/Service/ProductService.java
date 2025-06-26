package com.example.Product.Inventory.Management.Service;

import com.example.Product.Inventory.Management.Dto.ProductDto;
import com.example.Product.Inventory.Management.Entity.ProductEntity;
import com.example.Product.Inventory.Management.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{
    @Autowired
    private ProductRepo productRepo;
    public ProductEntity addProduct(ProductDto productDto)
    {
        ProductEntity productEntity=new ProductEntity();
        productEntity.setProductName(productDto.getProductName());
        productEntity.setProductDescr(productDto.getProductDescr());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setCategory(productDto.getCategory());
        productEntity.setUnit(productDto.getUnit());


        productRepo.save(productEntity);
        return productEntity;

    }


    public List<ProductEntity> getAllProductList() {
        return productRepo.findAll();
    }

    public Optional<ProductEntity> getProductById(Long id) {
        return productRepo.findById(id);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);

    }

    public ProductEntity updateProduct(Long id, ProductDto productDto)
    {
        ProductEntity existingdata = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        existingdata.setProductDescr(productDto.getProductDescr());
        existingdata.setPrice(productDto.getPrice());
        existingdata.setCategory(productDto.getCategory());
        existingdata.setUnit(productDto.getUnit());

        productRepo.save(existingdata);
        return existingdata;
    }

    public ProductEntity updateProductPartially(Long id, ProductDto productDto)
    {
        ProductEntity existingdata = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        //existingdata.setProductDescr(productDto.getProductDescr());
        existingdata.setPrice(productDto.getPrice());
       // existingdata.setCategory(productDto.getCategory());
        existingdata.setUnit(productDto.getUnit());

        productRepo.save(existingdata);
        return existingdata;
    }
}
