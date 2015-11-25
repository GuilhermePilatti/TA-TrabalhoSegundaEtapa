/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.ClienteFisico;
import br.edu.ifsul.modelo.Fornecedor;
import br.edu.ifsul.modelo.ItensPedido;
import br.edu.ifsul.modelo.MateriaPrima;
import br.edu.ifsul.modelo.Pedido;
import br.edu.ifsul.modelo.Produto;
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
public class TesteInserirPedidoItens {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteInserirPedidoItens() {
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
            Pedido p = new Pedido();
            ItensPedido ip = new ItensPedido();
            
            p.setCliente(em.find(ClienteFisico.class, 2));
            p.setDataPedido(Calendar.getInstance());
            p.setPesoTotal(1500.000);
            p.setQuantidadeSacas(50);
            p.setValorTotal(3229.00);
            
            ip.setPeso(1500.00);
            ip.setProduto(em.find(Produto.class, 1));
            ip.setQuantidade(50);
            ip.setPedido(p);
            
            p.adicionarItem(ip);
            
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
