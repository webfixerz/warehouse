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
    
    /**
    * <p>This method will create a new product</p>
    * @param warehouseId the ID of the warehouse where the product will be saved
    * @param product the product that will be saved
    * @since 1.0
    */
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
    
    /**
    * <p>This method will return all the products of a warehouse</p>
    * @param warehouseId The ID of the warehouse
    * @return the products
    * @since 1.0
    */
    @GetMapping()
    public Iterable<Product> readProducts(@PathVariable("warehouseId") int warehouseId) {
        return this.productRepository.findByWarehouseId(warehouseId);
    }
    
    /**
    * <p>This method will return a product with corresponding ID</p>
    * @param productId The ID of the product
    * @return the prdouct
    * @since 1.0
    */
    @GetMapping(value = "/{productId}")
    public Product readProduct(@PathVariable("productId") int productId) {
        Product p;
        p = this.productRepository.findById(productId).get();
        return p;
    }
    
    /**
    * <p>This method will update a product</p>
    * @param productId The ID of the old product
    * @param product The new information
    * @return the new product
    * @since 1.0
    */
    @PutMapping(value = "/{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
        return this.productRepository.findById(productId).map(p -> {
            p.setName(product.getName());
            return this.productRepository.save(p);
        }).get();
    }
    
    /**
    * <p>This method will delete a product and updates the warehouse</p>
    * @param productId The ID of the product
    * @param warehouseId The ID of the warehouse where the product will be removed
    * @since 1.0
    */
    @DeleteMapping(value = "/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId, @PathVariable int warehouseId) {
        Warehouse warehouse = this.warehouseRepository.findById(warehouseId).get();
        warehouse.deleteProduct(productId);
        this.warehouseRepository.save(warehouse);
        this.productRepository.deleteById(productId);        
    }
    
    /**
    * <p>This method will transfer a product to another warehouse</p>
    * @param idFrom ID of the old warehouse
    * @param idTo ID of the new warehouse
    * @param productId ID of product
    * @since 1.0
    */
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
