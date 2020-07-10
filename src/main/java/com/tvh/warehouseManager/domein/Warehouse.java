package com.tvh.warehouseManager.domein;

import com.tvh.warehouseManager.exception.NoCapacityLeftException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This is the warehouse class. This class is the center of the project.
 * Warehouses can contain products.
 *
 * @author simon
 */
@Entity
@Table(name = "warehouses")
public class Warehouse {
    /**
    * The ID of the warehouse
    * This attribute will be generated by the database if the warehouse is new.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    /**
    * The name of the warehouse
    */
    private String name;
    
    /**
    * The maximum number of products that the warehouse can contain
    */
    private int maximumCapacity;
    
    /**
    * The number of products that the warehouse has.
    */
    private int capacityUsed;
    
    /**
    * The list of products that the warehouse contains
    * Warehouse has the responsibility for mapping the products
    */
    @OneToMany(mappedBy = "warehouse")
    private List<Product> products;
    
    /**
    * <p>This constructor will be used to get data from the database</p>
    * @since 1.0
    */
    public Warehouse() {}

    /**
    * <p>This constructor will be used to make new warehouses</p>
    * @param maximumCapacity the amount of products that the warehouse can contain
    * @param name the name of the warehouse
    * @since 1.0
    */
    public Warehouse(int maximumCapacity, String name) {
        this.maximumCapacity = maximumCapacity;
        this.capacityUsed = 0;
        this.products = new ArrayList<>();
        this.name = name;
    }

    /**
    * <p>This method will return the ID of the warehouse</p>
    * @return the ID
    * @since 1.0
    */
    public int getId() {
        return id;
    }

    /**
    * <p>This method will set a new ID</p>
    * @param id the new ID for the warehouse
    * @since 1.0
    */
    public void setId(int id) {
        this.id = id;
    }

    /**
    * <p>This method will return the name of the warehouse</p>-
    * @return the name
    * @since 1.0
    */
    public String getName() {
        return name;
    }

    /**
    * <p>This method will set a new name</p>
    * @param name the new name
    * @since 1.0
    */
    public void setName(String name) {
        if(name != null && name.trim().length() > 3) {
            this.name = name;
        }
    }

    /**
    * <p>This method will return the capacity that is used</p>
    * @return the used capacity
    * @since 1.0
    */
    public int getCapacityUsed() {
        return capacityUsed;
    }

    /**
    * <p>This method will return the maximum capacity</p>
    * @return the maximum capacity
    * @since 1.0
    */
    public int getMaximumCapacity() {
        return maximumCapacity;
    }
    
    /**
    * <p>This method will set a new maximum capacity</p>
    * @param maximumCapacity the new capacity
    * @since 1.0
    */
    public void setMaximumCapacity(int maximumCapacity) {
        if(maximumCapacity > this.capacityUsed) {
            this.maximumCapacity = maximumCapacity;
        } else {
            throw new NoCapacityLeftException("There is no free space in warehouse " + this.getName() + ", so you can't delete capacity");
        }
    }

    /**
    * <p>This method will return the products of the warehouse</p>-
    * @return the products
    * @since 1.0
    */
    public List<Product> getProducts() {
        return products;
    }
    
    /**
    * <p>This method will return the free capacity</p>
    * @return the capacity left
    * @since 1.0
    */
    public int calculateCapacityLeft() {
        return this.maximumCapacity - this.capacityUsed;
    }
    
    /**
    * <p>This method will add a new product</p>
    * @param product the product added in the warehouse
    * @since 1.0
    */
    public void addProduct(Product product) {
        if(this.maximumCapacity > this.capacityUsed) {
            this.products.add(product);
            this.capacityUsed++;
        } else {
            throw new NoCapacityLeftException("There is no free space in warehouse (" + this.getId() + ") " + this.getName());
        }
    }
    
    /**
    * <p>This method will delete the product with given ID</p>
    * @param id the ID of the product that will be deleted
    * @return the deleted product
    * @since 1.0
    */
    public Product deleteProduct(int id) {
        Product product = this.products.stream().filter(p -> p.getId() == id).findFirst().get();
        this.products.remove(product);
        this.capacityUsed--;
        return product;
    }
}
