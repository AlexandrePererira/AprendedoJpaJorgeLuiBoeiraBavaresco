/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cursoJorge.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alexandre
 */
public class EntityManagerUtil {
    
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;
    
    public static EntityManager getEntityManager(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory("CursoJpaJorge");
        }
        if(em == null){
            em = factory.createEntityManager();
        }
        return em;
    
    }
    
}
