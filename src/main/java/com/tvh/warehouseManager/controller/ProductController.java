/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvh.warehouseManager.controller;

import com.tvh.warehouseManager.domein.Product;
import com.tvh.warehouseManager.domein.Warehouse;
import com.tvh.warehouseManager.repositories.ProductRepository;
import com.tvh.warehouseManager.repositories.WarehouseRepository;
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
import service.ProductService;
import service.ProductServiceImpl;
import service.WarehouseService;
import service.WarehouseServiceImpl;

/**
 *
 * @author simon
 */
@RestController
@RequestMapping("warehouses/{warehouseId}/products")
public class ProductController {

    /*@Autowired
    public ProductService productservice;

    @Autowired
    public WarehouseService warehouseservice;*/
    
    @Autowired
    public ProductRepository productRepository;
    
    @Autowired
    public WarehouseRepository warehouseRepository;
    
    public ProductController() {
        
    }
    
    @PostMapping
    public void createProduct(@PathVariable("warehouseId") int warehouseId, @RequestBody Product product) {
        Warehouse warehouse = this.warehouseRepository.findById(warehouseId).orElseThrow(NullPointerException::new);
        warehouse.addProduct(product);
        product.setWarehouse(warehouse);
        System.out.println(warehouse.calculateCapacityLeft());
        System.out.println(warehouse.getCapacityUsed());
        this.productRepository.save(product);
        this.warehouseRepository.save(warehouse);
        //this.productRepository.save(product, this.warehouseRepository.findById(warehouseId).get());
    }
    
    @GetMapping()
    public Iterable<Product> readProducts(@PathVariable("warehouseId") int warehouseId) {
        return this.productRepository.findByWarehouseId(warehouseId);
    }
    
    @GetMapping(value = "/{productId}")
    public Product readProduct(@PathVariable("productId") int productId) {
        return this.productRepository.findById(productId).get();
    }
    
    @PutMapping(value = "/{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
        //return this.productRepository.updateProduct(productId, product);
        return this.productRepository.findById(productId).map(p -> {
            p.setName(product.getName());
            return this.productRepository.save(p);
        }).get();
    }
    
    @DeleteMapping(value = "/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId) {
        this.productRepository.deleteById(productId);
    }
    
}
