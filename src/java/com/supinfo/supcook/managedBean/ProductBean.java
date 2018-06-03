/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.managedBean;

import com.supinfo.supcook.ejb.session.ProductDAOBeanLocal;
import com.supinfo.supcook.ejb.session.UserDAOBeanLocal;
import com.supinfo.supcook.entities.Category;
import com.supinfo.supcook.entities.Product;
import com.supinfo.supcook.entities.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class ProductBean implements Serializable{
    
    
      
  @EJB
  ProductDAOBeanLocal productDao;

    private Product product;
  
    private List<Product> productList;

    public ProductBean() {
       this.product = new Product();
       productList = new ArrayList<Product>();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @PostConstruct
    public void init() {
        productList = productDao.listAll();
        // If this is a static list, you'd rather put this
        // in a separate application scoped bean instead.
    }
    public List<Product>productById(){
        productList = new ArrayList<Product>();
        productList = productDao.listAllByID(product.getId());
        return productList;
    }
    
    public List<Product>productById(Long productID){
        productList = new ArrayList<Product>();
        productList = productDao.listAllByID(productID);
        return productList;
    }
    
    public List<Product> getProductList() {
        productList = new ArrayList<Product>();
        productList = productDao.listAll();
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    
}
