/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.ejb;

import com.supinfo.supcook.ejb.session.UserDAOBeanLocal;
import com.supinfo.supcook.entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author farouk
 */

@Stateless
public class UserDAOBean extends EntityCommonImpl<Users, Long> implements UserDAOBeanLocal{
    
    public UserDAOBean(){
        super(Users.class);
    }

    @Override
    public Boolean credentialIsValid(String username, String password) {
        
         String jpql = "SELECT u FROM " + Users.class.getSimpleName() + " u WHERE u.username LIKE '%" + username+"%' AND u.password LIKE '%"+password+"%'";
        Query query = this.entityManager.createQuery(jpql);
        
        return query.getResultList().size() > 0;
    }

    @Override
    public Long getUserIdByUserName(String username) {
         String jpql = "SELECT u FROM " + Users.class.getSimpleName() + " u WHERE u.username LIKE '%" + username+"%'";
        Query query = this.entityManager.createQuery(jpql);
        List<Users> list = query.getResultList();
        return list.get(0).getId();
    }
    
    
    
}
