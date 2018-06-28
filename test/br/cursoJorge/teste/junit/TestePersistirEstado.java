/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cursoJorge.teste.junit;

import br.cursoJorge.jpa.EntityManagerUtil;
import br.cursoJorge.modelo.Estado;
import br.cursoJorge.modelo.Pais;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Alexandre
 */
public class TestePersistirEstado {
    
    EntityManager em;
    
    public TestePersistirEstado() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
        
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
       boolean exception = false;
       try{
           Estado estado = new Estado();
           estado.setNome("São Paulo");
           estado.setUf("SP");
           estado.setPais(em.find(Pais.class, 1));
           em.getTransaction().begin();
           em.persist(estado);
           em.getTransaction().commit();        
       }catch(Exception e){
           exception = true;
           e.printStackTrace();
           
       
       }
        Assert.assertEquals(false, exception);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
