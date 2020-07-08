/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvh.oefening.controller;

import com.tvh.oefening.domein.Product;
import com.tvh.oefening.domein.Warehouse;
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
import org.springframework.web.bind.annotation.RequestMethod;
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
        this.warehouseRepository.createWarehouse(warehouse);
        return warehouse;
    }
    
    @GetMapping()
    public List<Warehouse> readWarehouses() {
        return this.warehouseRepository.getWarehouses();
    }
    
    @GetMapping(value = "{id}")
    public Warehouse readWarehouse(@PathVariable int id) {
        return this.warehouseRepository.getWarehouseById(id);
    }
    
    @PutMapping(value = "{warehouseId}")
    public Warehouse updateWarehouse(@PathVariable int warehouseId, @RequestBody Warehouse warehouse) {
        this.warehouseRepository.updateWarehouse(warehouseId, warehouse);
        return this.warehouseRepository.getWarehouseById(warehouseId);
    }
    
    @DeleteMapping(value = "{warehouseId}")
    public void deleteWarehouse(@PathVariable int warehouseId) {
        this.warehouseRepository.deleteWarehouse(warehouseId);
    }
    
    @PutMapping(value = "transfer/{idFrom}/{idTo}/{productID}")
    public void transferProduct(@PathVariable int idFrom, @PathVariable int idTo, @PathVariable int productID) {
        this.warehouseRepository.transferProduct(idFrom, idTo, productID);
    }
}
