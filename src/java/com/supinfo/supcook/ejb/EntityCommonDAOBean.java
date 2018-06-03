/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.ejb;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author farouk
 * @param <T>
 * @param <PK>
 */

@Local
public interface EntityCommonDAOBean <T, PK extends Serializable>{
    
    public T add(T t);
    
    public T update(T t);
    
    public void delete (T t);
    
    public void deleteById(PK id);
    
    public List<T> listAll();
    
    public List<T> listAllByID(PK id);
    
    public T UserByID(PK id);
    
}