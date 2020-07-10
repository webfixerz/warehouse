/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tvh.warehouseManager.domain;

import com.tvh.warehouseManager.domein.Product;
import com.tvh.warehouseManager.domein.Warehouse;
import com.tvh.warehouseManager.exception.NoCapacityLeftException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author simon
 */
public class WarehouseUnitTest {
    private Warehouse warehouse;
    
    public WarehouseUnitTest() {
    }
    
    @BeforeEach
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void addProduct_productCanBeAdded_works() {
        //Arrange
        warehouse = new Warehouse(1, "warehouse");
        
        
        //Act
        warehouse.addProduct(new Product());
        
        //Assert
        assertEquals(1, warehouse.getProducts().size());
    }
    
    @Test
    public void addProduct_spaceFull_Fails() {
        //Arrange
        warehouse = new Warehouse(1, "warehouse");
        warehouse.addProduct(new Product());
        
        //Act
        NoCapacityLeftException thrown = assertThrows(
           NoCapacityLeftException.class,
           () -> warehouse.addProduct(new Product()),
           "Expected addProduct() to throw, but it didn't"
        );

        //Assert
        assertTrue(thrown.getMessage().contains(warehouse.getName()));
    }
    
    @Test
    public void setCapacity_newCapacityHigherThanUsedCapacity_Works() {
        //Arrange
        warehouse = new Warehouse(5, "warehouse");
        warehouse.addProduct(new Product());
        warehouse.addProduct(new Product());
        
        //Act
        warehouse.setMaximumCapacity(3);
        
        //Assert
        assertEquals(3, warehouse.getMaximumCapacity());
    }
    
    @Test
    public void setCapacity_newCapacityLowerThanUsedCapacity_Fails() {
        //Arrange
        warehouse = new Warehouse(3, "warehouse");
        warehouse.addProduct(new Product());
        warehouse.addProduct(new Product());
        
        //Act
        NoCapacityLeftException thrown = assertThrows(
           NoCapacityLeftException.class,
           () -> warehouse.setMaximumCapacity(1),
           "Expected setMaximumCapacity() to throw, but it didn't"
        );
        
        //Assert
        assertTrue(thrown.getMessage().contains(warehouse.getName()));
    }
}
