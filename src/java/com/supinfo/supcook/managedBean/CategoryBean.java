/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.managedBean;

import com.supinfo.supcook.ejb.session.CategoryDAOBeanLocal;
import com.supinfo.supcook.ejb.session.RecipeDAOBeanLocal;
import com.supinfo.supcook.ejb.session.UserDAOBeanLocal;
import com.supinfo.supcook.entities.Category;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author farouk
 */

@ViewScoped
@Named
public class CategoryBean implements Serializable{
    
    @EJB
    CategoryDAOBeanLocal categoryDao;

    Category category;
    List <Category> categoryList;
    public CategoryBean() {
    }

    public CategoryDAOBeanLocal getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDAOBeanLocal categroyDao) {
        this.categoryDao = categroyDao;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
    public List<Category>categories(){
        categoryList = new ArrayList<Category>();
        categoryList = categoryDao.listAll();
        return categoryList;
    }
    
    public List<Category>categoryById(){
        categoryList = new ArrayList<Category>();
        categoryList = categoryDao.listAllByID(category.getId());
        return categoryList;
    }
    
    public List<Category>categoryById(Long categoryID){
        categoryList = new ArrayList<Category>();
        categoryList = categoryDao.listAllByID(categoryID);
        return categoryList;
    }
    
    public String addCategory(){
        this.categoryDao.add(category);
        System.out.println(""+category.toString());
        return "index";
    }  
  
}
