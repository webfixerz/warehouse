/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvh.warehouseManager.service;

import com.tvh.warehouseManager.domein.Warehouse;
import com.tvh.warehouseManager.repositories.WarehouseRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author simon
 */
//@Service
public class WarehouseServiceImpl implements WarehouseService{
    
    @Autowired
    private WarehouseRepository warehouseRepository;
    
    @Override
    public Warehouse findById(int id) {
        return warehouseRepository.findById(id).get();
    }

    @Override
    public void save(Warehouse warehouse) {
        this.warehouseRepository.save(warehouse);
    }

    @Override
    public Iterable<Warehouse> findAll() {
        return this.warehouseRepository.findAll();
    }

    @Override
    public void updateWarehouse(int warehouseId, Warehouse newWarehouse) {
        this.warehouseRepository.findById(warehouseId).map(w -> {
            w.setName(newWarehouse.getName());
            w.setMaximumCapacity(newWarehouse.getMaximumCapacity());
            return this.warehouseRepository.save(w);
        });
    }

    @Override
    public void deleteById(int warehouseId) {
        this.warehouseRepository.deleteById(warehouseId);
    }
    
    
}
