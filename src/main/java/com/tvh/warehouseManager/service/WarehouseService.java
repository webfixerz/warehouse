/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvh.warehouseManager.service;

import com.tvh.warehouseManager.domein.Warehouse;

/**
 *
 * @author simon
 */
public interface WarehouseService {
    
    public Warehouse findById(int id);
    
    public void save(Warehouse warehouse);
    
    public Iterable<Warehouse> findAll();
    
    public void updateWarehouse(int warehouseId, Warehouse newWarehouse);
    
    public void deleteById(int warehouseId);
    
    
}
