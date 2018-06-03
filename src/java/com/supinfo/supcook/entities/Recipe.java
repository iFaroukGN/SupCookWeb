/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author farouk
 */

@Entity

public class Recipe implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id")
    private Long Id;
    
    @Column(name="recipe_name")
    private String recipeName;
    
    @Column(name="time_preparation", nullable = false)
    private int timePreparation;
    
    @Column(name="recipe_picture")
    private String recipePicture;
    
    @Column(name="time_cooking", nullable = false)
    private int timeOfCooking;
    
    @Column(name="description", nullable = false)
    private String description;
    
    @Column(name="difficulty_level", nullable = false)
    private int difficultyLevel;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;
    
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "recipe_product", joinColumns = @JoinColumn(name = "id_R", referencedColumnName = "recipe_id"), 
            inverseJoinColumns = @JoinColumn(name = "id_P", referencedColumnName = "product_id"))
    private List<Product> productList;

    public Recipe() {
    }

    public Recipe(String recipeName, int timePreparation, String recipePicture, int timeOfCooking, String description, int difficultyLevel, Users user, Category category, List<Product> productList) {
        this.recipeName = recipeName;
        this.timePreparation = timePreparation;
        this.recipePicture = recipePicture;
        this.timeOfCooking = timeOfCooking;
        this.description = description;
        this.difficultyLevel = difficultyLevel;
        this.user = user;
        this.category = category;
        this.productList = productList;
    }

    public String getRecipePicture() {
        return recipePicture;
    }

    public void setRecipePicture(String recipePicture) {
        this.recipePicture = recipePicture;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public int getTimePreparation() {
        return timePreparation;
    }

    public void setTimePreparation(int timePreparation) {
        this.timePreparation = timePreparation;
    }

    public int getTimeOfCooking() {
        return timeOfCooking;
    }

    public void setTimeOfCooking(int timeOfCooking) {
        this.timeOfCooking = timeOfCooking;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recipe other = (Recipe) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Recipe{" + "Id=" + Id + ", recipe name=" + recipeName + ", recipe picture=" + recipePicture + ", description=" + description + ", difficulty level=" + difficultyLevel + ", time of cooking=" + timeOfCooking + ", time of preparation=" + timePreparation + '}';
    }
    
    
}
