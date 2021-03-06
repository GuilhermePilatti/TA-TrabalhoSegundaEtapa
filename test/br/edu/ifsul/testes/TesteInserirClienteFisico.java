/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.ClienteFisico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ws
 */
public class TesteInserirClienteFisico {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteInserirClienteFisico() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-Trabalho-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean excecao = false;
        try{
            ClienteFisico pf = new ClienteFisico();
            pf.setCpf("774.784.645-21");
            pf.setEndereco("Rua A");
            pf.setNome("Guilherme");
            pf.setRg("0123456789");
            pf.setCidade("Passo Fundo");
            
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
            
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch(Exception e){
            excecao = true;
            e.printStackTrace();
        }
        
        //Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
