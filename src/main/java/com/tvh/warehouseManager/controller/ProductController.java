package com.tvh.warehouseManager.controller;

import com.tvh.warehouseManager.domein.Product;
import com.tvh.warehouseManager.domein.Warehouse;
import com.tvh.warehouseManager.repositories.ProductRepository;
import com.tvh.warehouseManager.repositories.WarehouseRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a REST-controller that will handle all the requests with warehouses/{warehouseId}/products in the URL.
 * This controller is focused on the products in a warehouse.
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
    
    /**
    * The productRepository that will be used for database operations
    * This attribute will receive a reference to the object by Spring
    */
    @Autowired
    public ProductRepository productRepository;
    
    /**
    * The warehouseRepository that will be used for database operations
    * This attribute will receive a reference to the object by Spring
    */
    @Autowired
    public WarehouseRepository warehouseRepository;
    
    public ProductController() {
        
    }
    
    @PostMapping
    public void createProduct(@PathVariable("warehouseId") int warehouseId, @RequestBody Product product) {
        this.warehouseRepository.findById(warehouseId).map(warehouse -> {
            if(warehouse == null) {
                throw new EntityNotFoundException("ProductID " + warehouseId + " was not found!");
            }
            warehouse.addProduct(product);
            product.setWarehouse(warehouse);
            this.productRepository.save(product);
            return this.warehouseRepository.save(warehouse);
        });
    }
    
    @GetMapping()
    public Iterable<Product> readProducts(@PathVariable("warehouseId") int warehouseId) {
        return this.productRepository.findByWarehouseId(warehouseId);
    }
    
    @GetMapping(value = "/{productId}")
    public Product readProduct(@PathVariable("productId") int productId) {
        Product p;
        //try {
            p = this.productRepository.findById(productId).get();
        //} catch(NoSuchElementException ex) {
        //    throw new EntityNotFoundException("ProductID " + productId + " was not found!");
        //}
        return p;
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
    
    @PutMapping(value = "/transfer/{productId}/{idTo}")
    public void transferProduct(@PathVariable("warehouseId") int idFrom, @PathVariable("idTo") int idTo, @PathVariable("productId") int productId) {
        this.productRepository.findById(productId).map(p -> {
            Warehouse w1 = this.warehouseRepository.findById(idFrom).get();
            w1.deleteProduct(productId);
            Warehouse w2 = this.warehouseRepository.findById(idTo).get();
            w2.addProduct(p);
            p.setWarehouse(w2);
            this.warehouseRepository.save(w1);
            this.warehouseRepository.save(w2);
            return this.productRepository.save(p);
        });
    } 
}
