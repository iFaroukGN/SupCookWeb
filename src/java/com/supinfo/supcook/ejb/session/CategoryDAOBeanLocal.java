/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.ejb.session;

import com.supinfo.supcook.ejb.EntityCommonDAOBean;
import com.supinfo.supcook.entities.Category;
import javax.ejb.Local;

/**
 *
 * @author farouk
 */
@Local
public interface CategoryDAOBeanLocal extends EntityCommonDAOBean<Category, Long>{
    
}

