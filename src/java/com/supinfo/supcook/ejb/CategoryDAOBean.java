/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.ejb;

import com.supinfo.supcook.ejb.session.CategoryDAOBeanLocal;
import com.supinfo.supcook.entities.Category;
import javax.ejb.Stateless;

/**
 *
 * @author farouk
 */

@Stateless
public class CategoryDAOBean extends EntityCommonImpl<Category, Long> implements CategoryDAOBeanLocal{
    
    public CategoryDAOBean(){
        super(Category.class);
    }
    
}
