/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cursoJorge.teste;

import br.cursoJorge.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alexandre
 */
public class TestePersistirPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursoJpaJorge");
        EntityManager em = emf.createEntityManager();
        
        Pais pais = new Pais();
      
        pais.setNome("Brasil");
        pais.setIso("BRA");
        
        em.getTransaction().begin();
        em.persist(pais);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
        
    }
    
}
