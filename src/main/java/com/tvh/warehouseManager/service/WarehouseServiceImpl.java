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
