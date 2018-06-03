/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.ejb.session;

import com.supinfo.supcook.ejb.EntityCommonDAOBean;
import com.supinfo.supcook.entities.Recipe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author farouk
 */
@Local
public interface RecipeDAOBeanLocal extends EntityCommonDAOBean<Recipe, Long>{
    
    public List<Recipe> getRecipeByName(String recipeName);
}
