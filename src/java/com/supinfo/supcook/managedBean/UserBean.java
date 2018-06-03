/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.managedBean;

import com.supinfo.supcook.ejb.session.UserDAOBeanLocal;
import com.supinfo.supcook.entities.Users;
import com.supinfo.utils.SessionUtils;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author farouk
 */

@SessionScoped
@Named
public class UserBean  implements Serializable{
    
  @EJB
  UserDAOBeanLocal userDao;

    private Users currentUser;
  
    private List<Users> userList;

    public UserBean() {
       this.currentUser = new Users();
    }
  
    public List<Users> getUsers(){
       
        userList = userDao.listAll();
        
        return userList;
    }
    
    public Users getCurrentUser(){
        return currentUser;
    }
    
    public Users setCurrentUser(Users currentUser){
        this.currentUser = currentUser;
        return this.currentUser;
    }
    
    public List<Users> getUserById(Users u){
        
        userList = userDao.listAllByID(u.getId());
        
        return userList;
    }
    
    public String subscribe(){
        Users u = userDao.add(currentUser);
        System.out.println(" "+currentUser.toString());
        
      if(u != null){
		HttpSession session = SessionUtils.getSession();
		session.setAttribute("username", u.getUsername());
                session.setAttribute("user", u);
                session.setAttribute("userid", u.getId());
                System.out.println(" username from session ... "+SessionUtils.getUserName()+" user id ... "+SessionUtils.getUserId()+" object to string ... "+u.toString());
                return "index";
        } 
        return "";
    }    
    
    public String login() {
		boolean isValid = userDao.credentialIsValid(currentUser.getUsername(), currentUser.getPassword());
		if (isValid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", currentUser.getUsername());
                        session.setAttribute("user", currentUser);
                        session.setAttribute("userid", userDao.getUserIdByUserName(currentUser.getUsername()));
                        System.out.println(" username from session ... "+SessionUtils.getUserName()+" user id from session ... "+SessionUtils.getUserId()+" user id from object ... "+currentUser.getId()+" object to string ... "+SessionUtils.getUser().toString());
			return "index";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
    }

    public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "isLogOutindex";
	}
    
    public void search(){
        
    }
}
