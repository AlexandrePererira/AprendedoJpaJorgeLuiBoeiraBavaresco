/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cursoJorge.teste.junit;

import br.cursoJorge.jpa.EntityManagerUtil;
import br.cursoJorge.modelo.Endereco;
import br.cursoJorge.modelo.PessoaFisica;
import br.cursoJorge.modelo.TipoEndereco;
import java.util.Calendar;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Alexandre
 */
public class TestePersistirEndereco {

    EntityManager em;

    public TestePersistirEndereco() {
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
    public void teste() {
        boolean exception = false;
        try {

            EntityManager em = EntityManagerUtil.getEntityManager();
            PessoaFisica pessoa = em.find(PessoaFisica.class, 2);
       
            pessoa.removerEndereco(pessoa.getEnderecos().get(0).getId());

            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        } catch (Exception e) {
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
