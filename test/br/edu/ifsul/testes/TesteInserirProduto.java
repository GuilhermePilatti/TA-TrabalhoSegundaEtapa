/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.ClienteFisico;
import br.edu.ifsul.modelo.Fornecedor;
import br.edu.ifsul.modelo.MateriaPrima;
import br.edu.ifsul.modelo.Produto;
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
public class TesteInserirProduto {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteInserirProduto() {
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
            Produto p = new Produto();
            p.setNome("PigMix Crescimento 30");
            p.setFase("Crescimento");
            p.setValorUnitario(64.58);
            p.setPesoSaca(30);
            
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch(Exception e){
            excecao = true;
            e.printStackTrace();
        }
        
        //Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
