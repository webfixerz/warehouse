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
    Iterable<Product> findByWarehouseId(int warehouseId);
    Optional<Product> findByIdAndWarehouseId(int id, int warehouseId);
}
