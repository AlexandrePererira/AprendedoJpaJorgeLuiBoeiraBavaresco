/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cursoJorge.teste.junit;

import br.cursoJorge.jpa.EntityManagerUtil;
import br.cursoJorge.modelo.PessoaFisica;
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
public class TestePersistirPessoa {
    
    EntityManager em;
    
    public TestePersistirPessoa() {
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
           
           PessoaFisica pessoa = new PessoaFisica();
           pessoa.setCpf("286.826.150-70");
           pessoa.setEmail("testepessoafisica@gmail.com");
           pessoa.setNascimento(Calendar.getInstance());
           pessoa.setNome("Yasmin Soares");
           pessoa.setNomeUsuario("Yasminprincesa");
           pessoa.setRg("422295329");
           pessoa.setTelefone("(16)38117898");
           pessoa.setSenha("12312364");
           
           
           em.getTransaction().begin();
           em.persist(pessoa);
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
