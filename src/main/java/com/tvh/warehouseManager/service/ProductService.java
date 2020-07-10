package com.tvh.warehouseManager.service;

import com.tvh.warehouseManager.domein.Product;
import com.tvh.warehouseManager.domein.Warehouse;

/**
 * This interface contains all the methodes that can be called by the controller.
 *
 * @author simon
 */
public interface ProductService {
    
    /**
    * <p>This method will save a product in the given warehouse</p>
    * @param product the product that will be saved
    * @param warehouse the warehouse where the product will be saved
    * @since 1.0
    */
    public void save(Product product, Warehouse warehouse);

    /**
    * <p>This method will return all the products of a warehouse</p>
    * @param warehouseId the ID of the warehouse
    * @return the products of that warehouse
    * @since 1.0
    */
    public Iterable<Product> findByWarehouseId(int warehouseId);

    /**
    * <p>This method will return the product with corresponding ID</p>
    * @param productId the ID of the product
    * @return the product
    * @since 1.0
    */
    public Product findById(int productId);

    /**
    * <p>This method will update an existing product</p>
    * @param productId the id of the product that will be updated
    * @param product the product that contains the new information
    * @return the new product
    * @since 1.0
    */
    public Product updateProduct(int productId, Product product);
    
    /**
    * <p>This method will delete an existing product</p>
    * @param productId the id of the product
    * @since 1.0
    */
    public void deleteById(int productId);
}
