package com.supinfo.supcook.entities;

import com.supinfo.supcook.entities.Recipe;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-05T10:42:21")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile ListAttribute<Category, Recipe> recipeList;
    public static volatile SingularAttribute<Category, Long> Id;
    public static volatile SingularAttribute<Category, String> categoryName;

}