package com.supinfo.supcook.entities;

import com.supinfo.supcook.entities.Recipe;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-05T10:42:21")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile ListAttribute<Product, Recipe> recipe;
    public static volatile SingularAttribute<Product, Long> Id;
    public static volatile SingularAttribute<Product, String> productName;

}