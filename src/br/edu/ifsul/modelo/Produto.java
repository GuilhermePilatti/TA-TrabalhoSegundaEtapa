/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author ws
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_codigo", allocationSize = 1)
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve possui mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotBlank(message = "A fase deve ser informada")
    @Length(max = 50, message = "A fase não deve possui mais de {max} caracteres")
    @Column(name = "fase", length = 50, nullable = false)
    private String fase;
    
    @NotNull(message = "O valor unitário deve ser informado")
    @Column(name = "valorunitario", columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private Double valorUnitario;
    
    @NotNull(message = "O peso da saca deve ser informado")
    @Column(name = "pesosaca", columnDefinition = "integer")
    private Integer pesoSaca;
    
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItensProduto> itensProduto = new ArrayList<>();

    public Produto() {
    }
    
    public void adicionarItem(ItensProduto obj){
        obj.setProduto(this);
        itensProduto.add(obj);
    }
    
    public void removeritem(int index){
        itensProduto.remove(index);
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getPesoSaca() {
        return pesoSaca;
    }

    public void setPesoSaca(Integer pesoSaca) {
        this.pesoSaca = pesoSaca;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public List<ItensProduto> getItensProduto() {
        return itensProduto;
    }

    public void setItensProduto(List<ItensProduto> itensProduto) {
        this.itensProduto = itensProduto;
    }
}
