/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.ejb;

import com.supinfo.supcook.ejb.session.RecipeDAOBeanLocal;
import com.supinfo.supcook.entities.Recipe;
import com.supinfo.supcook.entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author farouk
 */

@Stateless
public class RecipeDAOBean extends EntityCommonImpl<Recipe, Long> implements RecipeDAOBeanLocal{
    
    public RecipeDAOBean() {
        super(Recipe.class);
    }

    @Override
    public List<Recipe> getRecipeByName(String recipeName) {
        
         String jpql = "SELECT r FROM " + Recipe.class.getSimpleName() + " r WHERE r.recipe_name LIKE '%" + recipeName+"%'";
        Query query = this.entityManager.createQuery(jpql);
        
        return query.getResultList();
    }
    
}
