/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.managedBean;

import com.supinfo.supcook.ejb.session.CategoryDAOBeanLocal;
import com.supinfo.supcook.ejb.session.ProductDAOBeanLocal;
import com.supinfo.supcook.ejb.session.RecipeDAOBeanLocal;
import com.supinfo.supcook.ejb.session.UserDAOBeanLocal;
import com.supinfo.supcook.entities.Category;
import com.supinfo.supcook.entities.Product;
import com.supinfo.supcook.entities.Recipe;
import com.supinfo.supcook.entities.Users;
import com.supinfo.utils.SessionUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;

/**
 *
 * @author farouk
 */

@ViewScoped
@Named
public class RecipeBean implements Serializable{
    
    @EJB
    RecipeDAOBeanLocal recipeDao;

    @EJB
    UserDAOBeanLocal userDao;
  
    @EJB
    ProductDAOBeanLocal productDao;

    @EJB
    CategoryDAOBeanLocal categoryDao;
    
    private Users user;
    
    private Long recipeID;
    
    private List<Product> productList;
  
    private List<Category> categoryList;
    
    private UploadedFile uploadedFile;

    private Recipe recipe;
  
    private Part file;
    
    private List<Recipe> recipeList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<Product>();
        categoryList = new ArrayList<Category>();
        productList = productDao.listAll();
        categoryList = categoryDao.listAll();
        
        if (recipeID == null) {
            String message = "Bad request. Please use a link from within the system.";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return;
        }

        if (recipeDao.listAllByID(recipeID).size() < 0) {
            String message = "Bad request. Unknown recipe.";
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }
        
        // If this is a static list, you'd rather put this
        // in a separate application scoped bean instead.
    }

    public Long getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(Long recipeID) {
        this.recipeID = recipeID;
    }

    public Part getFile() {
        return file;
    }

    public Users getUser() {
        return SessionUtils.getUser();
    }

    public void setUser(Users user) {
        this.user = user;
    }

    
    public void setFile(Part file) {
        this.file = file;
    }

    public List<Product> getProductList() {
        productList = new ArrayList<Product>();
        productList = productDao.listAll();
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Category>getCategoryList(){
        categoryList = new ArrayList<Category>();
        categoryList = categoryDao.listAll();
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    
    
    public RecipeBean() {
       this.recipe = new Recipe();
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<Recipe> getRecipeList() {
       
        return recipeDao.listAll();
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
  
    
    public List<Recipe> getARecipByID(){
        return recipeDao.listAllByID(recipeID);
    }
   
    public String addRecipe() throws IOException{
        this.submit();
        recipe.setUser(getCurrentUser());
        recipeDao.add(recipe);
        System.out.println(""+recipe.toString());
        return "/Login/index";
    }    
    
    public String updateRecipe(){
        recipeDao.update(recipe);
        System.out.println(" update ... "+recipe.toString());
        return "index";
    }
    
    public String deleteRecipe(Recipe recipe){
        recipeDao.deleteById(recipe.getId());
        System.out.println(""+recipe.toString());
        return "index";
    }
    
    public void saveFile() {
    try (InputStream input = file.getInputStream()) {
        Files.copy(input, new File("uploads", file.getSubmittedFileName()).toPath());
        this.recipe.setRecipePicture(file.getSubmittedFileName());
    }
    catch (IOException e) {
        // Show faces message?
    }
    }   
    
    public void submit() throws IOException {
       // String fileName = FilenameUtils.getName(uploadedFile.getName());
       if(uploadedFile != null){
           recipe.setRecipePicture(uploadedFile.getName());
        String contentType = uploadedFile.getContentType();
        byte[] bytes = uploadedFile.getBytes();

        // Now you can save bytes in DB (and also content type?)

        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(String.format("File '%s' of type '%s' successfully uploaded!", uploadedFile.getName(), contentType)));
       }
       
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    
    public void search(){
        
    }
    
    private Users getCurrentUser(){
        Users u = null;
        
        u = userDao.UserByID(SessionUtils.getUserId()); 
       
        return u;
    }
}
