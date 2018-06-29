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
public class TesteRemoverPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursoJpaJorge");
        EntityManager em = emf.createEntityManager();
        
        Pais pais = em.find(Pais.class, 3);
       
        
        em.getTransaction().begin();
        em.remove(pais);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
        
    }
    
}
