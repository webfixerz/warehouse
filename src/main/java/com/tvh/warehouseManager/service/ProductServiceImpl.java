package com.tvh.warehouseManager.service;

import com.tvh.warehouseManager.domein.Product;
import com.tvh.warehouseManager.domein.Warehouse;
import com.tvh.warehouseManager.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class implements the ProductService interface and will be 
 * used by the controller
 *
 * @author simon
 */
//@Service
public class ProductServiceImpl implements ProductService{
    
    /**
    * The productRepository that will be used for database operations
    * This attribute will receive a reference to the object by Spring
    */
    @Autowired
    private ProductRepository productRepository;

    /**
    * <p>This method will save a product in the given warehouse</p>
    * @param product the product that will be saved
    * @param warehouse the warehouse where the product will be saved
    * @since 1.0
    */
    @Override
    public void save(Product product, Warehouse warehouse) {
        product.setWarehouse(warehouse);
        this.productRepository.save(product);
    }

    /**
    * <p>This method will return all the products of a warehouse</p>
    * @param warehouseId the ID of the warehouse
    * @return the products of that warehouse
    * @since 1.0
    */
    @Override
    public Iterable<Product> findByWarehouseId(int warehouseId) {
        return this.productRepository.findByWarehouseId(warehouseId);
    }

    /**
    * <p>This method will return the product with corresponding ID</p>
    * @param productId the ID of the product
    * @return the product
    * @since 1.0
    */
    @Override
    public Product findById(int productId) {
        return this.productRepository.findById(productId).get();
    }

    /**
    * <p>This method will update an existing product</p>
    * @param productId the id of the product that will be updated
    * @param product the product that contains the new information
    * @return the new product
    * @since 1.0
    */
    @Override
    public Product updateProduct(int productId, Product product) {
        return this.productRepository.findById(productId).map(p -> {
            p.setName(product.getName());
            return this.productRepository.save(p);
        }).get();
    }

    /**
    * <p>This method will delete an existing product</p>
    * @param productId the id of the product
    * @since 1.0
    */
    @Override
    public void deleteById(int productId) {
        this.productRepository.deleteById(productId);
    }
    
}
