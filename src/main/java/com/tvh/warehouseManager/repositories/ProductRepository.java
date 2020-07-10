package com.tvh.warehouseManager.repositories;

import com.tvh.warehouseManager.domein.Product;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * This is the repository that will communicate with the H2 in memory database about products
 *
 * @author simon
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
    
    /**
    * <p>This method will return all the products of a warehouse</p>
    * @param warehouseId the ID of the warehouse
    * @return the products of that warehouse
    * @since 1.0
    */
    Iterable<Product> findByWarehouseId(int warehouseId);
}
