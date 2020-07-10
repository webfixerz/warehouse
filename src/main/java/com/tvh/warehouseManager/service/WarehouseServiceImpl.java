package com.tvh.warehouseManager.service;

import com.tvh.warehouseManager.domein.Warehouse;
import com.tvh.warehouseManager.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class implements the ProductService interface and will be 
 * used by the controller
 *
 * @author simon
 */
//@Service
public class WarehouseServiceImpl implements WarehouseService{
    
    /**
    * The warehouseRepository that will be used for database operations
    * This attribute will receive a reference to the object by Spring
    */
    @Autowired
    private WarehouseRepository warehouseRepository;
    
    /**
    * <p>This method will return a warehouse with the correspondig ID</p>
    * @param id the ID of the warehouse
    * @return the warehouse
    * @since 1.0
    */
    @Override
    public Warehouse findById(int id) {
        return warehouseRepository.findById(id).get();
    }

    /**
    * <p>This method will save a warehouse</p>
    * @param warehouse the new warehouse
    * @since 1.0
    */
    @Override
    public void save(Warehouse warehouse) {
        this.warehouseRepository.save(warehouse);
    }

    /**
    * <p>This method will return all the warehouses</p>
    * @return a list of warehouses
    * @since 1.0
    */
    @Override
    public Iterable<Warehouse> findAll() {
        return this.warehouseRepository.findAll();
    }

    /**
    * <p>This method will update an existing warehouse</p>
    * @param warehouseId the ID of the old warehouse
    * @param newWarehouse the new information about the warehouse
    * @since 1.0
    */
    @Override
    public void updateWarehouse(int warehouseId, Warehouse newWarehouse) {
        this.warehouseRepository.findById(warehouseId).map(w -> {
            w.setName(newWarehouse.getName());
            w.setMaximumCapacity(newWarehouse.getMaximumCapacity());
            return this.warehouseRepository.save(w);
        });
    }

    /**
    * <p>This method will delete a warehouse</p>
    * @param warehouseId the ID of the warehouse that will be deleted
    * @since 1.0
    */
    @Override
    public void deleteById(int warehouseId) {
        this.warehouseRepository.deleteById(warehouseId);
    }
    
    
}
