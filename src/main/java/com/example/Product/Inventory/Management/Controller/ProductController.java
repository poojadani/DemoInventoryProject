package com.example.Product.Inventory.Management.Controller;

import com.example.Product.Inventory.Management.Dto.ProductDto;
import com.example.Product.Inventory.Management.Entity.ProductEntity;
import com.example.Product.Inventory.Management.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/products")

public class ProductController
{
    @Autowired
    ProductService productService;

    @PostMapping("/addproduct")
    public ResponseEntity<ProductEntity> addEmployee(@RequestBody ProductDto productDto)
    {
        return new ResponseEntity<>(productService.addProduct(productDto) , CREATED);

    }

    @GetMapping("/getProductList")
    public ResponseEntity<List<ProductEntity>> getAllProductList()
    {
        return new ResponseEntity<>(productService.getAllProductList(), HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}")
    public Optional<ProductEntity> getProductById(@PathVariable Long id)
    {
        return productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id)
    {
        productService.deleteProduct(id);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto)
    {
        return ResponseEntity.ok(productService.updateProduct(id,productDto));


    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ProductEntity> updateProductPartially(@PathVariable Long id, @RequestBody ProductDto productDto)
    {
        return ResponseEntity.ok(productService.updateProductPartially(id,productDto));

    }



}
