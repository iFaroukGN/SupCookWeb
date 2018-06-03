/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.utils;

import com.supinfo.supcook.ejb.CategoryDAOBean;
import com.supinfo.supcook.ejb.session.CategoryDAOBeanLocal;
import com.supinfo.supcook.entities.Category;
import com.supinfo.supcook.managedBean.CategoryBean;
import java.lang.annotation.Annotation;
import java.util.List;
import javax.ejb.EJB;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author farouk
 */

@FacesConverter(value = "categoryConverter")
public class CategoryConverter implements Converter{

    @EJB
    private CategoryDAOBeanLocal CategoryDAOBeanLocal;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        ValueExpression vex =
                context.getApplication().getExpressionFactory()
                        .createValueExpression(context.getELContext(),
                                "#{categoryBean}", CategoryBean.class);

        CategoryBean category = (CategoryBean)vex.getValue(context.getELContext());
        
        
        if (value.trim().equals("")) {
            return null;
        } else {
            List<Category> catList = category.categories();

            for (Category cat : catList) {
                
                    return cat;
                
            }

        }
        return null;
        
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        return ((Category)arg2).getId().toString();
    }

    
}
