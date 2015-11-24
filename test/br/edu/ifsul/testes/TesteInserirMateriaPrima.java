/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.ClienteFisico;
import br.edu.ifsul.modelo.Fornecedor;
import br.edu.ifsul.modelo.MateriaPrima;
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
public class TesteInserirMateriaPrima {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteInserirMateriaPrima() {
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
            MateriaPrima mp = new MateriaPrima();
            mp.setNome("Feedox");
            mp.setFabricante("Impextraco");
            mp.setForcenedor(em.find(Fornecedor.class, 4));
            mp.setPesoSaca(25);
            
            em.getTransaction().begin();
            em.persist(mp);
            em.getTransaction().commit();
        } catch(Exception e){
            excecao = true;
            e.printStackTrace();
        }
        
        //Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
