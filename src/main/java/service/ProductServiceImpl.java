/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.tvh.warehouseManager.domein.Product;
import com.tvh.warehouseManager.domein.Warehouse;
import com.tvh.warehouseManager.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author simon
 */
//@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(Product product, Warehouse warehouse) {
        product.setWarehouse(warehouse);
        this.productRepository.save(product);
    }

    @Override
    public Iterable<Product> findByWarehouseId(int warehouseId) {
        return this.productRepository.findByWarehouseId(warehouseId);
    }

    @Override
    public Product findById(int productId) {
        return this.productRepository.findById(productId).get();
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        return this.productRepository.findById(productId).map(p -> {
            p.setName(product.getName());
            return this.productRepository.save(p);
        }).get();
    }

    @Override
    public void deleteById(int productId) {
        this.productRepository.deleteById(productId);
    }
    
}
