/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.utils;

import com.supinfo.supcook.entities.Category;
import com.supinfo.supcook.entities.Product;
import com.supinfo.supcook.managedBean.CategoryBean;
import com.supinfo.supcook.managedBean.ProductBean;
import java.lang.annotation.Annotation;
import java.util.List;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author farouk
 */

@FacesConverter(value = "productConverter")
public class ProductConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        ValueExpression vex =
                context.getApplication().getExpressionFactory()
                        .createValueExpression(context.getELContext(),
                                "#{productBean}", ProductBean.class);

        ProductBean product = (ProductBean)vex.getValue(context.getELContext());
       
        
        if (value.trim().equals("")) {
            return null;
        } else {
            List<Product> prodList = product.getProductList();

            for (Product prod : prodList) {
                if (prod.getProductName().equals(value)) {
                    return prod;
                }
            }

        }
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        
        
         
        Product p = (Product)arg2;
        

        return p.getProductName();
        
        
    }

    
}
