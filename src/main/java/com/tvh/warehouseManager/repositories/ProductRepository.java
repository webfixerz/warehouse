/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvh.warehouseManager.repositories;

import com.tvh.warehouseManager.domein.Product;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author simon
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Iterable<Product> findByWarehouseId(int warehouseId);
    Optional<Product> findByIdAndWarehouseId(int id, int warehouseId);
}
