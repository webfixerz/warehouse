/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvh.oefening.controller;

import com.tvh.oefening.domein.Product;
import com.tvh.oefening.repositories.WarehouseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author simon
 */
@RestController
@RequestMapping("warehouses/{warehouseId}/products")
public class ProductController {
    
    @Autowired
    public WarehouseRepository warehouseRepository;
    
    @PostMapping
    public void createProduct(@PathVariable("warehouseId") int warehouseId, @RequestBody Product product) {
        this.warehouseRepository.makeProduct(warehouseId, product);
    }
    
    @GetMapping()
    public List<Product> readProducts(@PathVariable("warehouseId") int warehouseId) {
        return this.warehouseRepository.readProducts(warehouseId);
    }
    
    @GetMapping(value = "/{productId}")
    public Product readProduct(@PathVariable("warehouseId") int warehouseId, @PathVariable("productId") int productId) {
        return this.warehouseRepository.getProductById(warehouseId, productId);
    }
    
    @PutMapping(value = "/{productId}")
    public void updateProduct(@PathVariable("warehouseId") int warehouseId, @PathVariable("productId") int productId, @RequestBody Product product) {
        this.warehouseRepository.updateProductById(warehouseId, productId, product);
    }
    
    @DeleteMapping(value = "/{productId}")
    public void deleteProduct(@PathVariable("warehouseId") int warehouseId, @PathVariable("productId") int productId) {
        this.warehouseRepository.deleteProductById(warehouseId, productId);
    }
    
}
