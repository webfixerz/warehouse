/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvh.warehouseManager.domein;

/**
 *
 * @author simon
 */
public class Product {
    private int id;
    private String name;

    public Product() {}
    
    public Product(int id, String name) {
        this.id = id;
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
    
    
}
