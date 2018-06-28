/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cursoJorge.teste;

import br.cursoJorge.jpa.EntityManagerUtil;
import br.cursoJorge.modelo.Pais;
import javax.persistence.EntityManager;

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
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Pais pais = new Pais();
      
        pais.setNome("Paraguai");
        pais.setIso("PRG");
        
        em.getTransaction().begin();
        em.persist(pais);
        em.getTransaction().commit();
        em.close();
    
        
        
        
    }
    
}
