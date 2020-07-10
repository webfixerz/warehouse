package com.tvh.warehouseManager.controller;

import com.tvh.warehouseManager.config.EmailConfig;
import com.tvh.warehouseManager.domein.Warehouse;
import com.tvh.warehouseManager.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a REST-controller that will handle all the requests with /warehouses in the URL.
 * This controller is focused on the warehouses.
 * 
 * @author simon
 */
@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    
    /*@Autowired
    public WarehouseService warehouseservice;*/
    
    /*@Autowired
    public EmailService emailService;*/
    
    /**
    * The warehouseRepository that will be used for database operations
    * This attribute will receive a reference to the object by Spring
    */
    @Autowired
    public WarehouseRepository warehouseRepository;
   
    /**
    * <p>This method will save a new warehouse</p>
    * @param warehouse the warehouse object
    * @since 1.0
    */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void createWarehouse(@RequestBody Warehouse warehouse) {
        this.warehouseRepository.save(warehouse);
    }
    
    /**
    * <p>This method will return all the warehouses</p>
    * @return list of warehouses
    * @since 1.0
    */
    @GetMapping
    public Iterable<Warehouse> readWarehouses() {
        return this.warehouseRepository.findAll();
    }
    
    /**
    * <p>This method will return the warehouse with corresponding ID</p>
    * @param warehouseId The ID of the warehouse
    * @return the warehouse
    * @since 1.0
    */
    @GetMapping(value = "{warehouseId}")
    public Warehouse readWarehouse(@PathVariable int warehouseId) {
        return this.warehouseRepository.findById(warehouseId).get();
    }
    
    /**
    * <p>This method will update an existing warehouse</p>
    * @param warehouseId ID of the old warehouse
    * @param newWarehouse warehouse with new information
    * @since 1.0
    */
    @PutMapping(value = "{warehouseId}")
    public void updateWarehouse(@PathVariable int warehouseId, @RequestBody Warehouse newWarehouse) {
        this.warehouseRepository.findById(warehouseId).map(w -> {
            w.setName(newWarehouse.getName());
            w.setMaximumCapacity(newWarehouse.getMaximumCapacity());
            return this.warehouseRepository.save(w);
        });
    }
    
    /**
    * <p>This method will delete a warehouse</p>
    * @param warehouseId ID of the warehouse
    * @since 1.0
    */
    @DeleteMapping(value = "{warehouseId}")
    public void deleteWarehouse(@PathVariable int warehouseId) {
        this.warehouseRepository.deleteById(warehouseId);
    }
    
}
