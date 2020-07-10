package com.tvh.warehouseManager.service;

import com.tvh.warehouseManager.domein.Product;
import com.tvh.warehouseManager.domein.Warehouse;

/**
 *
 * @author simon
 */
public interface ProductService {
    public void save(Product product, Warehouse warehouse);

    public Iterable<Product> findByWarehouseId(int warehouseId);

    public Product findById(int productId);

    public Product updateProduct(int productId, Product product);
    
    public void deleteById(int productId);
}
