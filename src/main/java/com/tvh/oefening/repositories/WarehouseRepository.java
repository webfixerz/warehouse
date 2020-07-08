/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvh.oefening.repositories;

import com.tvh.oefening.domein.Product;
import com.tvh.oefening.domein.Warehouse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author simon
 */
@Component
public class WarehouseRepository {
    
    public List<Warehouse> warehouses;
    
    public WarehouseRepository() {
        this.warehouses = new ArrayList<>();
        
        Warehouse a1 = new Warehouse(30, "Warehouse1");
        a1.setId(1);
        a1.setName("Simon");
        
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("Cookies");
        
        Product p2 = new Product();
        p2.setId(2);
        p2.setName("Brownies");
        
        Product p3 = new Product();
        p3.setId(3);
        p3.setName("Ringelings");
        
        a1.addProduct(p1);
        a1.addProduct(p2);
        a1.addProduct(p3);
        
        Warehouse a2 = new Warehouse(50, "Warehouse2");
        a2.setId(2);
        a2.setName("Luk");
        
        Product p4 = new Product();
        p4.setId(4);
        p4.setName("Melk");
        
        Product p5 = new Product();
        p5.setId(5);
        p5.setName("Water");
        
        Product p6 = new Product();
        p6.setId(6);
        p6.setName("Cola");
        
        a2.addProduct(p4);
        a2.addProduct(p5);
        a2.addProduct(p6);
        
        warehouses.add(a1);
        warehouses.add(a2);
    }

    public List<Warehouse> getWarehouses() {
        return this.warehouses;
    }

    public Warehouse getWarehouseById(int id) {
        return this.warehouses.stream().filter(w -> w.getId() == id).findFirst().get();
    }

    public void transferProduct(int idFrom, int idTo, int productID) {
        Warehouse w1 = warehouses.stream().filter(w -> w.getId() == idFrom).findAny().get();
        Warehouse w2 = warehouses.stream().filter(w -> w.getId() == idTo).findAny().get();
        Product p = w1.deleteProduct(productID);
        w2.addProduct(p);
    }

    public void createWarehouse(Warehouse warehouse) {
        this.warehouses.add(warehouse);
    }

    public void updateWarehouse(int id, Warehouse newWarehouse) {
        Warehouse warehouse = this.getWarehouseById(id);
        warehouse.setName(newWarehouse.getName());
        warehouse.setMaximumCapacity(newWarehouse.getMaximumCapacity());
    }

    public void deleteWarehouse(int warehouseId) {
        this.warehouses.remove(this.warehouses.stream().filter(w -> w.getId() == warehouseId).findFirst().get());
    }

    public void makeProduct(int warehouseId, Product product) {
        this.getWarehouseById(warehouseId).addProduct(product);
    }

    public Product getProductById(int warehouseId, int productId) {
        return this.getWarehouseById(warehouseId).getProducts().stream().filter(p -> p.getId() == productId).findFirst().get();
    }

    public void updateProductById(int warehouseId, int productId, Product newProduct) {
        Product product = this.getProductById(warehouseId, productId);
        product.setName(newProduct.getName());
    }

    public void deleteProductById(int warehouseId, int productId) {
        this.getWarehouseById(warehouseId).removeProduct(this.getProductById(warehouseId, productId));
    }

    public List<Product> readProducts(int warehouseId) {
        return this.getWarehouseById(warehouseId).getProducts();
    }
}
