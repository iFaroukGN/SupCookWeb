/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.ejb;

import com.supinfo.supcook.ejb.session.ProductDAOBeanLocal;
import com.supinfo.supcook.entities.Product;
import javax.ejb.Stateless;

/**
 *
 * @author farouk
 */

@Stateless
public class ProductDAOBean extends EntityCommonImpl<Product, Long> implements ProductDAOBeanLocal{
    
    public ProductDAOBean(){
        super(Product.class);
    }
}
