package com.tvh.warehouseManager.repositories;

import com.tvh.warehouseManager.domein.Product;
import com.tvh.warehouseManager.domein.Warehouse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author simon
 */

public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {
    
}