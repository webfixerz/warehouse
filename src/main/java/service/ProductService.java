/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
