/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.ejb.session;

import com.supinfo.supcook.ejb.EntityCommonDAOBean;
import com.supinfo.supcook.entities.Users;

/**
 *
 * @author farouk
 */
public interface UserDAOBeanLocal extends EntityCommonDAOBean<Users, Long>{
    
    public Boolean credentialIsValid(String username, String password);
    public Long getUserIdByUserName(String username);
}
