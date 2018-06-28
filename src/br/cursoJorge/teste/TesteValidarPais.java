/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cursoJorge.teste;

import br.cursoJorge.modelo.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Alexandre
 */
public class TesteValidarPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursoJpaJorge");
        EntityManager em = emf.createEntityManager();

        Pais pais = new Pais();

        pais.setNome("Brasil");
        pais.setIso("slsljkskks");
      

        em.getTransaction().begin();
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validador.validate(pais);
        if (erros.size() > 0) {
            for (ConstraintViolation<Pais> erro : erros) {
                System.out.println("Erro: " + erro.getMessage());
            }
        } else {
            em.persist(pais);

        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
