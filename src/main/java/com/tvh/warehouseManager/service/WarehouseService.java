package com.tvh.warehouseManager.service;

import com.tvh.warehouseManager.domein.Warehouse;

/**
 * This interface contains all the methodes that can be called by the controller.
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
