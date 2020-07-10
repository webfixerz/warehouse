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
    
    public WarehouseController(){}
        
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void createWarehouse(@RequestBody Warehouse warehouse) {
        this.warehouseRepository.save(warehouse);
    }
    
    @GetMapping
    public Iterable<Warehouse> readWarehouses() {
        return this.warehouseRepository.findAll();
    }
    
    @GetMapping(value = "{warehouseId}")
    public Warehouse readWarehouse(@PathVariable int warehouseId) {
        return this.warehouseRepository.findById(warehouseId).get();
    }
    
    @PutMapping(value = "{warehouseId}")
    public void updateWarehouse(@PathVariable int warehouseId, @RequestBody Warehouse newWarehouse) {
        this.warehouseRepository.findById(warehouseId).map(w -> {
            w.setName(newWarehouse.getName());
            w.setMaximumCapacity(newWarehouse.getMaximumCapacity());
            return this.warehouseRepository.save(w);
        });
        //this.warehouseRepository.updateWarehouse(warehouseId, newWarehouse);
    }
    
    @DeleteMapping(value = "{warehouseId}")
    public void deleteWarehouse(@PathVariable int warehouseId) {
        this.warehouseRepository.deleteById(warehouseId);
    }
    
}
