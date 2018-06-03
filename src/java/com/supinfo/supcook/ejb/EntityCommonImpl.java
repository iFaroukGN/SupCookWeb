/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcook.ejb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author farouk
 * @param <T>
 * @param <PK>
 */

public class EntityCommonImpl<T, PK extends Serializable> implements EntityCommonDAOBean<T, PK>{

    
    @PersistenceContext(unitName = "SupCookWebPU")
    protected EntityManager entityManager;
    protected Class<T> entityClass;

    public EntityCommonImpl(){
        
    }
    
    public EntityCommonImpl(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    @Override
    public T add(T t) {
        if(this.entityManager != null){
             this.entityManager.persist(t);
        }
        return t;
    }

    @Override
    public T update(T t) {
       this.entityManager.merge(t);
       return t;
    }

    @Override
    public void delete(T t) {
        T objToRemove = this.entityManager.merge(t);
        this.entityManager.remove(objToRemove);
    }

    @Override
    public void deleteById(PK id) {
        T objToRemove = this.entityManager.find(this.entityClass, id);
        this.entityManager.remove(objToRemove);
    }

    @Override
    public List<T> listAll() {
        String jpql = "SELECT o FROM " + this.entityClass.getSimpleName() + " o";
        Query query = this.entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<T> listAllByID(PK id) {
        String jpql = "SELECT o FROM " + this.entityClass.getSimpleName() + " o WHERE o.Id = " + id;
        Query query = this.entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public T UserByID(PK id) {
       T user = this.entityManager.find(this.entityClass, id);
       return  user; 
    }
    
}