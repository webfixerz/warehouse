package com.tvh.warehouseManager.service;

import com.tvh.warehouseManager.domein.Warehouse;

/**
 * This interface contains all the methodes that can be called by the controller.
 *
 * @author simon
 */
public interface WarehouseService {
    
    /**
    * <p>This method will return a warehouse with the correspondig ID</p>
    * @param id the ID of the warehouse
    * @return the warehouse
    * @since 1.0
    */
    public Warehouse findById(int id);
    
    /**
    * <p>This method will save a warehouse</p>
    * @param warehouse the new warehouse
    * @since 1.0
    */
    public void save(Warehouse warehouse);
    
    /**
    * <p>This method will return all the warehouses</p>
    * @return a list of warehouses
    * @since 1.0
    */
    public Iterable<Warehouse> findAll();
    
    /**
    * <p>This method will update an existing warehouse</p>
    * @param warehouseId the ID of the old warehouse
    * @param newWarehouse the new information about the warehouse
    * @since 1.0
    */
    public void updateWarehouse(int warehouseId, Warehouse newWarehouse);
    
    /**
    * <p>This method will delete a warehouse</p>
    * @param warehouseId the ID of the warehouse that will be deleted
    * @since 1.0
    */
    public void deleteById(int warehouseId);
    
    
}
