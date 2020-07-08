/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvh.warehouseManager.controller;

import com.tvh.warehouseManager.domein.Warehouse;
import com.tvh.warehouseManager.repositories.WarehouseRepository;
import java.util.List;
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
 *
 * @author simon
 */
@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    
    @Autowired
    public WarehouseRepository warehouseRepository;
    
    public WarehouseController() {}
        
    @PostMapping()
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
        this.warehouseRepository.save(warehouse);
        //this.warehouseRepository.createWarehouse(warehouse);
        return warehouse;
    }
    
    @GetMapping()
    public Iterable<Warehouse> readWarehouses() {
        return this.warehouseRepository.findAll();
    }
    
    @GetMapping(value = "{warehouseId}")
    public Warehouse readWarehouse(@PathVariable int warehouseId) {
        System.out.println(warehouseId);
        return this.warehouseRepository.findById(warehouseId).get();
    }
    
    @PutMapping(value = "{warehouseId}")
    public Warehouse updateWarehouse(@PathVariable int warehouseId, @RequestBody Warehouse newWarehouse) {
        return this.warehouseRepository.findById(warehouseId).map(w -> {
            w.setName(newWarehouse.getName());
            w.setMaximumCapacity(newWarehouse.getMaximumCapacity());
            return this.warehouseRepository.save(w);
        }).get();
    }
    
    @DeleteMapping(value = "{warehouseId}")
    public void deleteWarehouse(@PathVariable int warehouseId) {
        this.warehouseRepository.deleteById(warehouseId);
    }
    
    /*@PutMapping(value = "transfer/{idFrom}/{idTo}/{productID}")
    public void transferProduct(@PathVariable int idFrom, @PathVariable int idTo, @PathVariable int productID) {
        this.warehouseRepository.transferProduct(idFrom, idTo, productID);
    }*/
}
