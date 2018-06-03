package com.supinfo.supcook.entities;

import com.supinfo.supcook.entities.Category;
import com.supinfo.supcook.entities.Product;
import com.supinfo.supcook.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-05T10:42:21")
@StaticMetamodel(Recipe.class)
public class Recipe_ { 

    public static volatile SingularAttribute<Recipe, String> recipeName;
    public static volatile SingularAttribute<Recipe, Integer> timeOfCooking;
    public static volatile SingularAttribute<Recipe, Integer> difficultyLevel;
    public static volatile SingularAttribute<Recipe, String> description;
    public static volatile SingularAttribute<Recipe, Long> Id;
    public static volatile SingularAttribute<Recipe, Category> category;
    public static volatile SingularAttribute<Recipe, Users> user;
    public static volatile ListAttribute<Recipe, Product> productList;
    public static volatile SingularAttribute<Recipe, Integer> timePreparation;
    public static volatile SingularAttribute<Recipe, String> recipePicture;

}