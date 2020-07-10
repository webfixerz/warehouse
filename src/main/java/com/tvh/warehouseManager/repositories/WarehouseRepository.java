package com.tvh.warehouseManager.repositories;

import com.tvh.warehouseManager.domein.Warehouse;
import org.springframework.data.repository.CrudRepository;

/**
 * This is the repository that will communicate with the H2 in memory database about warehouses
 *
 * @author simon
 */

public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {
    
}