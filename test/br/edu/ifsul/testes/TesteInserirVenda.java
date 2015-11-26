/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.ClienteFisico;
import br.edu.ifsul.modelo.Pedido;
import br.edu.ifsul.modelo.Venda;
import java.util.Calendar;
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
public class TesteInserirVenda {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteInserirVenda() {
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
            Venda v = new Venda();
            v.setDataEntrega(Calendar.getInstance());
            v.setDataVenda(Calendar.getInstance());
            v.setPesoTotal(1500.000);
            v.setQuantidadeSacas(50);
            v.setValorTotal(3229.00);
            v.setPedido(em.find(Pedido.class, 1));
            
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } catch(Exception e){
            excecao = true;
            e.printStackTrace();
        }
        
        //Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
