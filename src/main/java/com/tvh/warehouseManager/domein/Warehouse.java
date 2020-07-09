/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvh.warehouseManager.domein;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author simon
 */
@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int maximumCapacity;
    private int capacityUsed;
    @OneToMany(mappedBy = "warehouse")
    //@JsonManagedReference
    private List<Product> products;
    
    public Warehouse() {}

    public Warehouse(int maximumCapacity, String name) {
        this.maximumCapacity = maximumCapacity;
        this.capacityUsed = 0;
        this.products = new ArrayList<>();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && name.trim().length() > 3) {
            this.name = name;
        }
    }

    public int getCapacityUsed() {
        return capacityUsed;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }
    
    public void setMaximumCapacity(int maximumCapacity) {
        if(maximumCapacity > this.capacityUsed) {
            this.maximumCapacity = maximumCapacity;
        } else {
            
        }
    }

    public List<Product> getProducts() {
        return products;
    }
    
    public int calculateCapacityLeft() {
        return this.maximumCapacity - this.capacityUsed;
    }
    
    public void addProduct(Product p) {
        if(this.maximumCapacity > this.capacityUsed) {
            this.products.add(p);
            this.capacityUsed++;
        }
    }
    
    public Product deleteProduct(int id) {
        Product product = this.products.stream().filter(p -> p.getId() == id).findFirst().get();
        this.products.remove(product);
        this.capacityUsed--;
        return product;
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }
}
